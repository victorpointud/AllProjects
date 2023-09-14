package proyectohotel;

/*
* Juan2808
*/

/*
* Esta clase implementa un árbol binario de búsqueda genérico que soporta 
* las operaciones de agregar y buscar un nodo
*/

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    /*
     * Se inserta el nodo.
     */ 
    public void insert(T data) {
        root = insertNode(root, data);
    }
    
    /*
     * Se inserta de manera recursiva el nodo en el nodo derecho o izquierdo apropiado
     * según los valores comparados.
     */
    public Node insertNode(Node current, T data) {
        if (current == null) {
            return new Node(data);
        }
        int comparison = data.compareTo(current.data);
        if (comparison < 0) {
            current.left = insertNode(current.left, data);
        } 
        else if (comparison > 0) {
            current.right = insertNode(current.right, data);
        } 
        else {
            return current;
        }
        return current;
    }
    
    /*
     * Obtiene la data.
     */
    public T getData(T data) {
        Node node = searchNode(root, data);
        if(node == null)
            return null;
        return node.data;
    }
    
    /*
     * Se busca de manera recursiva el nodo con el valor T.
     */
    
    public Node searchNode(Node node, T data) {
        if (node == null) {
            return null;
        }
        int comparison = data.compareTo(node.data);
        if (comparison == 0) {
            return node;
        } 
        else if (comparison < 0) {
            return searchNode(node.left, data);
        } 
        else {
            return searchNode(node.right, data);
        }
    }
}