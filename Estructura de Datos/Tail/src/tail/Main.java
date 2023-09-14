package tail;

/**
 *
 * @author victorpointud
 */

public class Main {
    
    public static void main(String[] args) {
        Tail tail = new Tail();
        Tail tail2 = new Tail();
        Tail tail3 = new Tail();
        
        System.out.println("\nTail 1.\n");
        
        tail.add(2);
        tail.add(45);
        tail.add(77);
        tail.add(13);
        tail.add(10);
        tail.add(98);
        tail.add(77);
        tail.add(10);;
        tail.add(5);
        
        tail.addAt(66, 4);
 
        tail.delete(98);
        
        tail.deleteFirst();
        
        tail.deleteAt(5);
        
        tail.deleteDuplicated();
        
        tail.print();
        
        tail.mayToMinSort();
        
        System.out.println("\nTail 2.\n");
        
        tail2.add(2);
        tail2.add(45);
        tail2.add(77);;
        tail2.add(13);
        tail2.add(10);
        tail2.add(98);
        tail2.add(77);
        tail2.add(0);
        tail2.add(5);
     
        tail3.report(tail, tail2);

        tail2.checkIfPalindrome();

        tail2.normalReverse();
        
        tail2.print();
        
        tail2.minToMaySort();
        
    }
    
}
