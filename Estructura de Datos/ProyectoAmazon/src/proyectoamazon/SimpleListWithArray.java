
package proyectoamazon;

/**
 *
 * @author luisarismendi
 */

public class SimpleListWithArray {
    private int first;
    private int last;
    private int size;
    public NodeSimpleListWithArray[] array;

    public SimpleListWithArray(int max) {
        this.first = this.last = -1;
        this.size = 0;
        this.array = new NodeSimpleListWithArray[max];
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    
    public boolean isEmpty() {
        return first == -1;
    }
    
    public boolean isFull() {
        return size == this.array.length;
    }
    
    public void empty() {
        this.first = this.last = -1;
        this.size = 0;
        this.array = new NodeSimpleListWithArray[this.array.length];
    }
    
    public String getValue(int x){
        String p = null;
        if (this.isEmpty()){
            return null;
        }
        if (x > this.array.length){
            System.out.println("El indice es mayor que la longitud de la lista");
        }
        else{
        for (int i = 0; i < this.array.length; i++) {
            if(i == x){
                p = (String) this.array[i].getData();
            }  
        }
        return p;
    }
    return p;
    }
    
    public int getIndex(String x){
        for (int i = 0; i < this.getLength(); i++) {
            if (x.equals(this.array[i].getData())){
                return i;
            }
        }
        return -1;
    }
    
    public int searchEmptySlot() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public void addAtTheStart(String x) {
        if (!this.isFull()) {
            NodeSimpleListWithArray node = new NodeSimpleListWithArray(x);
            int position = this.searchEmptySlot();
            this.array[position] = node;
            if (this.isEmpty()) {
                this.first = this.last = position;
            } else {
                this.array[position].setNext(this.first);
                this.first = position;
            }
            this.size++;
        }
    }
    
    public void addAtTheEnd(String x) {
        if (!this.isFull()) {
            NodeSimpleListWithArray node = new NodeSimpleListWithArray(x);
            int position = this.searchEmptySlot();
            this.array[position] = node;
            if (this.isEmpty()) {
                this.first = this.last = position;
            } else {
                this.array[this.last].setNext(position);
                this.last = position;
            }
            this.size++;
        }
    }
    
    
    public int getLength(){
        return size;
    }
}
