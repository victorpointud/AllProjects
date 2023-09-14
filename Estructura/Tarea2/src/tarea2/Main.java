
package tarea2;


/**
 *
 * @author victorpointud
 */

public class Main {

    public static void main(String[] args) {
        
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        
        doubleLinkedList.append(2);
        doubleLinkedList.append(45);
        doubleLinkedList.append(77);
        doubleLinkedList.append(13);
        doubleLinkedList.append(10);
        doubleLinkedList.append(98);
        doubleLinkedList.append(77);
        doubleLinkedList.append(10);
        doubleLinkedList.append(5);
        
        doubleLinkedList.preAppend(1);
        
        doubleLinkedList.append(0);
        
        doubleLinkedList.insert(66, 2);
        
        doubleLinkedList.delete(doubleLinkedList.search(98));
    
        doubleLinkedList.print();
            
        }
    }
    