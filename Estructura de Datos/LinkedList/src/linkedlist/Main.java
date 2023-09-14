
package linkedlist;


public class Main {

    
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        
        System.out.println("\nList 1.\n");
        
        linkedList.add(2);
        linkedList.add(45);
        linkedList.add(77);
        linkedList.add(13);
        linkedList.add(10);
        linkedList.add(98);
        linkedList.add(77);
        linkedList.add(10);;
        linkedList.add(5);
        
        linkedList.haveCicle();

        linkedList.addFirst(1);
        
        linkedList.addLast(0);
        
        linkedList.addAt(66, 2);
        
        linkedList.delete(linkedList.searchNode(98));
        
        linkedList.deleteFirst();
        
        linkedList.deleteLast();
        
        linkedList.deleteAt(5);
        
        linkedList.deleteDuplicated();
        
        linkedList.print();
        
        linkedList.minToMaySort();
        
        System.out.println("\nList 2.\n");
        
        linkedList2.add(2);
        linkedList2.add(45);
        linkedList2.add(77);;
        linkedList2.add(13);
        linkedList2.add(10);
        linkedList2.add(98);
        linkedList2.add(77);
        linkedList2.add(0);
        linkedList2.add(5);
            
        linkedList3.report(linkedList, linkedList2);
        
        linkedList2.checkIfPalindrome();
        
        linkedList2.normalReverse();
        
        linkedList2.print();;
        
        linkedList2.mayToMinSort();
        
        
    }

}
