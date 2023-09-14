
package circularlist;

/**
 *
 * @author victorpointud
 */

public class Main {

    public static void main(String[] args) {
        
        CircularList circularList = new CircularList();
        CircularList circularList2 = new CircularList();
        CircularList circularList3 = new CircularList();
        
        System.out.println("\nList 1.\n");
        
        circularList.add(2);
        circularList.add(45);
        circularList.add(77);
        circularList.add(13);
        circularList.add(10);
        circularList.add(98);
        circularList.add(77);
        circularList.add(10);;
        circularList.add(5);
        
        circularList.addFirst(1);
        
        circularList.addLast(0);
        
        circularList.addAt(66, 4);
 
        circularList.delete(98);
        
        circularList.deleteFirst();
        
        circularList.deleteLast();
        
        circularList.deleteAt(5);
        
        circularList.deleteDuplicated();
        
        circularList.print();
        
        System.out.println("\nList 2.\n");
        
        circularList2.add(2);
        circularList2.add(45);
        circularList2.add(77);;
        circularList2.add(13);
        circularList2.add(10);
        circularList2.add(98);
        circularList2.add(77);
        circularList2.add(0);
        circularList2.add(5);
     
        circularList3.report(circularList, circularList2);
    
        circularList2.checkIfPalindrome();
        
        circularList2.normalReverse();
        
        circularList2.print();
        
//        circularList2.sort();
    }
    
}
