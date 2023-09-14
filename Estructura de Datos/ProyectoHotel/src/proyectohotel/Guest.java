package proyectohotel;

/*
* Juan2808
*/

/*
 * Esta clase representa un huesped en la lista del 
 * histórico que tiene una habitación
*/

public class Guest {
    String ci;
    String name;
    String last_name;
    String email;
    String gender;
    String checkIn_date;
    
     public Guest(String ci, String name, String last_name, String email, String gender, String checkIn_date){
        this.ci = ci;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.checkIn_date = checkIn_date;
    }
}
