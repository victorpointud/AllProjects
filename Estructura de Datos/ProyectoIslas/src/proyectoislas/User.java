package proyectoislas;

/**
 *
 * @author victorpointud
 */

/**
* Representa a un usuario
*/
public class User {
    int id;
    String user;
    
    public User(int id, String user){
        this.id = id;
        this.user = user;
    }

    /**
    * Obtiene el Id.
    */
    public int getId() {
        return id;
    }

    /**
    * Setea el Id.
    */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
    * Obtiene el Usuario.
    */
    public String getUser() {
        return user;
    }

    /**
    * Setea el Usuario.
    */
    public void setUser(String user) {
        this.user = user;
    }
    
}