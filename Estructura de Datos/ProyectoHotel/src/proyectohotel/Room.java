package proyectohotel;

/*
* Juan 2808
*/

/*
* Clase que representa parte del ABB.
*/

public class Room implements Comparable<Room> {
    String id;
    LinkedList<Guest> history;
    
    public Room(String id){
        this.id = id;
        history = new LinkedList<>();
    }
    
    /*
    * Añade el huésped.
    */

    public void addGuest(Guest client){
        history.append(client);
    }
    
    /*
    * Obtiene el id.
    */

    public String getID(){
        return id;
    }
    
    /*
    * Obtiene la data del cliente.
    */

    public Guest getCliendData(int index){
        return history.get(index);
    }
    
    /*
    * Implementado para poder añadir un ABB de tipo Room.
    */

    public int compareTo(Room anotherRoom) {
        String anotherRoomID = anotherRoom.getID();
        return this.id.compareTo(anotherRoomID);
    }
}
