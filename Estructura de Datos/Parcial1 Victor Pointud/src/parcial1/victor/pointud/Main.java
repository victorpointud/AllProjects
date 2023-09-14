
package parcial1.victor.pointud;

/**
 *
 * @author victorpointud
 */

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        
//        System.out.println("\nList 1.\n");

        linkedList.add(2);
        linkedList.add(45);
        linkedList.add(77);
        linkedList.add(13);
        linkedList.add(10);
        linkedList.add(98);
        linkedList.add(77);
        linkedList.add(10);;
        linkedList.add(5);
        
        linkedList.removeDuplicated();

        linkedList.print();
        
//        System.out.println("\nList 2.\n");
        
        linkedList2.add(2);
        linkedList2.add(45);
        linkedList2.add(77);;
        linkedList2.add(13);
        linkedList2.add(10);
        linkedList2.add(98);
        linkedList2.add(77);
        linkedList2.add(0);
        linkedList2.add(5);
        
//        System.out.println("\nList 3.\n");
        
        linkedList3.add(2);
        linkedList3.add(45);
        linkedList3.add(77);;
        linkedList3.add(13);
        linkedList3.add(10);
        linkedList3.add(98);
        linkedList3.add(77);
        linkedList3.add(0);
        linkedList3.add(5);
        
//        linkedList4.unirListas(linkedList, linkedList2, linkedList3);
    }
    
}
