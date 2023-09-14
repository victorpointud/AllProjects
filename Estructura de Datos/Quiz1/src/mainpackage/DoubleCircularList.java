package mainpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author victorpointud
 */
public class DoubleCircularList {
    
    NodeRadioStation head;
    int total;
    boolean isEmpty = true;
    NodeRadioStation fav;

    public DoubleCircularList() {
        
        this.head = null;
        this.total = 0;
        this.fav = null;
    }

    public boolean getEmpty() {
    return isEmpty;
    }
    
    public NodeRadioStation getHead() {
        return head;
    }

    public void setHead(NodeRadioStation head) {
        this.head = head;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    public void insert(NodeRadioStation aux, int pos){

        if (isEmpty){
            
            this.setHead(aux);
            isEmpty = false;
            this.setTotal(getTotal()+1);
            return;
            
        }else if(pos == 0){
            
            aux.setNext(this.getHead());
            aux.setPrev(this.getHead().getPrev());
            this.getHead().setPrev(aux);
            this.setHead(aux);
            this.setTotal(getTotal()+1);
            return;
            
        }else if(pos > this.getTotal()){
            
            NodeRadioStation pointer = this.getHead();
            
            while(pointer.getNext() != null){
                
                pointer = pointer.getNext();
                
            }
            pointer.setNext(aux);
            aux.setPrev(pointer);
            aux.setNext(this.getHead());
            return;
        }
        else{
            
            NodeRadioStation pointer  = this.getHead();
            int cont = 1;
            
            while (pointer.getNext() != null){
                
                if(cont + 1 == pos){
                    
                    aux.setNext(pointer.getNext());
                    aux.setPrev(pointer);
                    pointer.getNext().setPrev(aux);
                    pointer.setNext(aux);
                    this.setTotal(getTotal()+1);
                    return;
                }
                
                pointer = pointer.next;
                cont++;
                
            }

        }
        
    }

    public NodeRadioStation getFav() {
        return fav;
    }

    public void setFav(NodeRadioStation fav) {
        this.fav = fav;
    }
    

        
     
}


