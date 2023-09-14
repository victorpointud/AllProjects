
package quiz2;

/**
 *
 * @author victorpointud
 */

public class NodeTree {
    NodeTree left;
    NodeTree right;
    NodeTree father;
    int data;
    int id;
    
    public NodeTree(int data, int id) {
        this.data = data;
        this.father = null;
        this.id = id;
        this.right = null;
        this.left = null;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    public NodeTree getFather() {
        return father;
    }

    public void setFather(NodeTree father) {
        this.father = father;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}