
package parcial2victorpointud;

/*
 * @author victorpointud
 */

public class BinaryTreeNode <T> {

    int data;
    BinaryTreeNode <T> rightSon;
    BinaryTreeNode <T> leftSon;
    BinaryTreeNode <T> father;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.rightSon = this.leftSon = this.father = null;
    }

    public int  getData() {
        return data;
    }

    public void setData(int  data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getRightSon() {
        return rightSon;
    }

    public void setRightSon(BinaryTreeNode<T> rightSon) {
        this.rightSon = rightSon;
    }
    
    public BinaryTreeNode<T> getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(BinaryTreeNode<T> leftSon) {
        this.leftSon = leftSon;
    }

    public BinaryTreeNode<T> getFather() {
        return father;
    }

    public void setFather(BinaryTreeNode<T> father) {
        this.father = father;
    }
    
}