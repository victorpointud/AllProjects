package proyectohotel;

/*
* vicxandra
*/

/*
 * Representa la lista de habitaciones con su record histótico de huéspedes y se encunetra implementada con un ABB.
 */

public class RoomHistory {
    BinarySearchTree<Room> rooms;
    
    public RoomHistory(){
        rooms = new BinarySearchTree<>();
    }
    
    /*
    * Añade una nueva habitación.
    */

    public void addRoom(String id){
        Room newRoom = new Room(id);
        rooms.insert(newRoom);
    }
    
    /*
    * Añade el registro 'guest' al nodo identificado con 'roomID'.
    */
    
    public void addRegister(String roomID, Guest client){
        Room tempNewRoom = new Room(roomID);
        Room room = rooms.getData(tempNewRoom);
        if(room != null){
            room.addGuest(client);
        } 
        else {
            System.out.println("La habitación " +  roomID + " no existe.");
        }
    }
    
    /* Obtiene el registro histórico de 'guests' del nodo identificado con 'roomID' para ello creamos una habitación vacia 
    * pero que contenga la el numHabi deseado ("tempNewRoom") y se la pasamos a getData para obtener los valores
    * reales de la habitación y su histórico.
    */
    
    public String getRoomHistory(String roomID){
        Room tempNewRoom = new Room(roomID);
        Room room = rooms.getData(tempNewRoom);
        String history = "Los clientes que se han hospedado en \nesta habitación son: \n\n";
        if(room != null){
            LinkedList<Guest> guests = room.history;
            int n = guests.size;
            for(int i=0; i < n; i++){
                Guest c = guests.get(i);
                history +=  " - " + c.name + " " + c.last_name + "\n";
                if(!c.ci.equals(""))
                    history +=  "    CI: " + c.ci + "\n";
                history +=  "    Email: " + c.email + "\n";
                history +=  "    Género: " + c.gender + "\n";
                history +=  "    Llegada: " + c.checkIn_date + "\n";
            }
            return history;
        } else {
            return "Está habitación no se encuentra en el hotel.";
        }
    }
}
