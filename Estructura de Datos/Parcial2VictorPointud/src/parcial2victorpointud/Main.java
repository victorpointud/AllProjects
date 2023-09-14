
package parcial2victorpointud;

/*
 * @author victorpointud
 */

public class Main {
    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(8);
    tree.insert(4);
    tree.insert(10);
    tree.insert(2);
    tree.insert(6);
    tree.insert(9);
    tree.insert(12);

    System.out.println("\n************ ÁRBOL ************\n");
    tree.preOrder(tree.root);
    System.out.println("\n*******************************\n");

    tree.findFloorAndCeiling(8); 
    tree.findFloorAndCeiling(4); 
    tree.findFloorAndCeiling(10); 
    tree.findFloorAndCeiling(2);
    tree.findFloorAndCeiling(6);
    tree.findFloorAndCeiling(9);
    tree.findFloorAndCeiling(12);

    System.out.println("\n*******************************\n");

    }
}
