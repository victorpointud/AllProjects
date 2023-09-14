package mainpackage;

/**
 *
 * @author victorpointud
 */
public class NodeRadioStation {
    String number;
    String Name;
    String Song;
    NodeRadioStation next;
    NodeRadioStation prev;

    public NodeRadioStation(String number, String Name, String Song) {
        
        this.number = number;
        this.Name = Name;
        this.Song = Song;
        this.next = null;
        this.prev = null;
    }


    public NodeRadioStation getNext() {
        return next;
    }

    public void setNext(NodeRadioStation next) {
        this.next = next;
    }

    public NodeRadioStation getPrev() {
        return prev;
    }

    public void setPrev(NodeRadioStation prev) {
        this.prev = prev;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSong() {
        return Song;
    }

    public void setSong(String Song) {
        this.Song = Song;
    }
    
}
