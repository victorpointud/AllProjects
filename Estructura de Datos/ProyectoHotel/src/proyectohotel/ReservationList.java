package proyectohotel;

/*
* vicxandra
*/

/*
 * Representa la lista de reservaciones históricas y se encunetra implementada con un ABB
 */

public class ReservationList {
    BinarySearchTree<Reservation> reservations;

    public ReservationList(){
       reservations = new BinarySearchTree<>();
    }

    /*
    * Añade la reservación.
    */

    public void addReservation(Reservation r){
       reservations.insert(r);
    }
    
    /*
     * Buscará la reservación con la cédula "ci", para ello creamos una reservación vacia pero que contenga la
     * ci de la reservación deseada ("tempReservation") y se la pasamos a getData para obtener los valores
     * reales de la reservación.
     */
    
    public String getReservationData(String ci){
        Reservation tempNewReservation = new Reservation(ci, "", "", "", "", "", "", "", "");
        Reservation reservation = reservations.getData(tempNewReservation);
        String data = "Los datos del cliente que realizó \nesta reservación son: \n\n";
        if(reservation != null){
            data += "Primer Nombre: " + reservation.name + "\n";
            data += "Segundo Nombre: " + reservation.last_name + "\n";
            data += "Correo: " + reservation.email + "\n";
            data += "Género: " + reservation.gender + "\n";
            data += "Tipo de habitación: " + reservation.tipo_hab + "\n";
            data += "Celular: " + reservation.phone + "\n";
            data += "Fecha de llegada: " + reservation.checkIn_date + "\n";
            data += "Fecha de salida: " + reservation.checkOut_date + "\n";
            return data;
        } else {
            return "No existe una reservación asociada \na esta cédula.";
        }
    }
}
