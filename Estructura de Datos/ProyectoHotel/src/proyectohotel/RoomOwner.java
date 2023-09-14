package proyectohotel;

/*
* vicxandra
*/

/*
* Representa un elemento de tabla de hash, donde se tiene los huéspedes actuales del hotel
*/

public class RoomOwner {
    String num_hab;
    String name;
    String last_name;
    String email;
    String gender;
    String phone;
    String checkIn_date;
    
    public RoomOwner(String num_hab, String name, String last_name, String email, String gender, String phone, String checkIn_date){
        this.num_hab = num_hab;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.checkIn_date = checkIn_date;
    }
    
    /*
    * Obtiene el número de habitación.
    */
    
    public String getRoomNumber(){
        return num_hab;
    }
    
    /*
    * Obtie el nombre.
    */
    
    public String getName(){
        return name;
    }
    
    /*
    * Obtiene el apellido.
    */
    
    public String getLastName(){
        return last_name;
    }
    
    /*
    * Obtiene el email.
    */
    
    public String getEmail(){
        return email;
    }
    
    /*
    * Obtiene el género.
    */
    
    public String getGender(){
        return gender;
    }
    
    /*
    * Obtiene la fecha.
    */
    
    public String getDate(){
        return checkIn_date;
    }
}
