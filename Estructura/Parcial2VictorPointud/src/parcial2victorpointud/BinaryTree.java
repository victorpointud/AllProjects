package parcial2victorpointud;

/*
 * @author victorpointud
 */

public class BinaryTree <T> {

    BinaryTreeNode <T> root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return getRoot() == null;
    }
    
    public void insert(int data) {
         this.root = insertNode(this.root, data);
     }

    public BinaryTreeNode insertNode(BinaryTreeNode node, int data) {
        if (node == null) {
            return new BinaryTreeNode(data);
        }
        if (data < node.getData()) {
            node.leftSon = insertNode(node.getLeftSon(), data);
        } 
        else if (data > node.data) {
            node.rightSon = insertNode(node.getRightSon(), data);
        }
        return node;
    }
    
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println("             { " + node.getData() + " } ");
            preOrder(node.getLeftSon());
            preOrder(node.getRightSon());
        }
    }
    
    public void findFloorAndCeiling(int key) {
        int floor = key;
        int ceiling = key;
        BinaryTreeNode curr = this.root;
        while (curr != null) {
            if (curr.getData() == key) {
                System.out.println("Piso: " + floor);
                System.out.println("Techo: " + ceiling);
                System.out.println();
                
                return;
            } else if (curr.getData() < key) {
                floor = curr.getData();
                curr = curr.getRightSon();
            } else {
                ceiling = curr.getData();
                curr = curr.getLeftSon();
            }
        }
        System.out.println("Piso: " + floor);
        System.out.println("Techo: " + ceiling);
    }
}