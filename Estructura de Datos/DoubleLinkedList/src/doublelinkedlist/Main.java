
package doublelinkedlist;

/**
 *
 * @author victorpointud
 */

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
        DoubleLinkedList doubleLinkedList3 = new DoubleLinkedList();
        
        System.out.println("\nList 1.\n");
        
        doubleLinkedList.add(2);
        doubleLinkedList.add(45);
        doubleLinkedList.add(77);
        doubleLinkedList.add(13);
        doubleLinkedList.add(10);
        doubleLinkedList.add(98);
        doubleLinkedList.add(77);
        doubleLinkedList.add(10);
        doubleLinkedList.add(5);
        
        doubleLinkedList.addFirst(1);
        
        doubleLinkedList.addLast(0);
        
        doubleLinkedList.addAt(66, 2);
        
        doubleLinkedList.delete(doubleLinkedList.searchNode(98));
        
        doubleLinkedList.deleteFirst();
        
        doubleLinkedList.deleteLast();
        
        doubleLinkedList.deleteAt(5);
        
        doubleLinkedList.deleteDuplicated();
        
        doubleLinkedList.print();
        
        doubleLinkedList.mayToMinSort();
        
        System.out.println("\nList 2.\n");
        
        doubleLinkedList2.add(2);
        doubleLinkedList2.add(45);
        doubleLinkedList2.add(77);
        doubleLinkedList2.add(13);
        doubleLinkedList2.add(10);
        doubleLinkedList2.add(98);
        doubleLinkedList2.add(77);
        doubleLinkedList2.add(0);
        doubleLinkedList2.add(5);
            
        doubleLinkedList3.report(doubleLinkedList, doubleLinkedList2);
        
        doubleLinkedList2.checkIfPalindrome();
        
        doubleLinkedList2.normalReverse();
        
        doubleLinkedList2.print();;
        
        doubleLinkedList2.minToMaySort();
        }
    
}
