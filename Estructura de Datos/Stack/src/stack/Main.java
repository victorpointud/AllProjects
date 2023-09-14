
package stack;

/**
 *
 * @author victorpointud
 */

public class Main {
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        
        System.out.println("\nStack 1.\n");
        
        stack.add(2);
        stack.add(45);
        stack.add(77);
        stack.add(13);
        stack.add(10);
        stack.add(98);
        stack.add(77);
        stack.add(10);;
        stack.add(5);
        
        stack.addAt(4, 66);
 
        stack.delete(stack.searchNode(98));
        
        stack.deleteFirst();
        
        stack.deleteAt(5);
        
        stack.deleteDuplicated();
        
        stack.print();
        
        stack.minToMaySort();
        
        System.out.println("\nStack 2.\n");
        
        stack2.add(2);
        stack2.add(45);
        stack2.add(77);;
        stack2.add(13);
        stack2.add(10);
        stack2.add(98);
        stack2.add(77);
        stack2.add(0);
        stack2.add(5);
     
        stack3.report(stack, stack2);

        stack2.checkIfPalindrome();

        stack2.normalReverse();
        
        stack2.print();
        
        stack2.mayToMinSort();
        
    }
}
