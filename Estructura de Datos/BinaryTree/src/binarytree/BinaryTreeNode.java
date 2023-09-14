
package binarytree;

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

    /*
     * Obtiene la informacion del nodo.
     */
    public int  getData() {
        return data;
    }

    /*
     * Setea la informacion del nodo.
     */
    public void setData(int  data) {
        this.data = data;
    }

    /*
     * Obtiene el nodo derecho.
     */
    public BinaryTreeNode<T> getRightSon() {
        return rightSon;
    }

    /*
     * Setea el nodo derecho.
     */
    public void setRightSon(BinaryTreeNode<T> rightSon) {
        this.rightSon = rightSon;
    }

    /*
     * Obtiene el nodo izquierdo.
     */
    public BinaryTreeNode<T> getLeftSon() {
        return leftSon;
    }

    /*
     * Setea el nodo izquierdo.
     */
    public void setLeftSon(BinaryTreeNode<T> leftSon) {
        this.leftSon = leftSon;
    }

    /*
     * Obtiene el nodo papa.
     */
    public BinaryTreeNode<T> getFather() {
        return father;
    }

    /*
     * Setea el nodo papa.
     */
    public void setFather(BinaryTreeNode<T> father) {
        this.father = father;
    }
    
}