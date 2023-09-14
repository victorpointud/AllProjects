package proyectohotel;

/*
* vicxandra
*/

/*
* Clase que representa parte del ABB.
*/

public class Reservation implements Comparable<Reservation> {
    String ci;
    String name;
    String last_name;
    String email;
    String gender;
    String tipo_hab;
    String phone;
    String checkIn_date;
    String checkOut_date;
    
    public Reservation(String ci, String name, String last_name, String email, String gender, 
        String tipo_hab, String phone, String checkIn_date, String checkOut_date){
        this.ci = ci;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.tipo_hab = tipo_hab;
        this.phone = phone;
        this.checkIn_date = checkIn_date;
        this.checkOut_date = checkOut_date;
    }
    
    /*
    * Obtiene el Id.
    */
    public String getID(){
        return ci;
    }
    
    /*
    * Implementado para poder implementar un ABB de tipo Reservation,
    * compara según la cédula.
    */
    
    public int compareTo(Reservation anotherReservation) {
        String anotherRoomID = anotherReservation.getID();
        return this.ci.compareTo(anotherRoomID);
    }
}
