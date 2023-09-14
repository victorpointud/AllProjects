package binarytree;

/*
 * @author victorpointud
 */

public class BinaryTree <T> {

    BinaryTreeNode <T> root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public class NodeWrapper
    {
        public BinaryTreeNode node;
 
        NodeWrapper(BinaryTreeNode node) {
            this.node = node;
        }
    }
    
    /*
     * Obtiene el nodo rama.
     */
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    /*
     * Setea el nodo rama.
     */
    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
    
    /*
     * Verifica si esta vacio.
     */
    public boolean isEmpty() {
        return getRoot() == null;
    }
    
    /*
     * Metodo preOrder.
     * Consiste en agarrar primero el nodo de la raiz, luego el izquierdo de ella y luego el derecho.
     */
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println("                          { " + node.data + " }");
            preOrder(node.leftSon);
            preOrder(node.rightSon);
        }
    }

    /*
     * Metodo inOrder.
     * Consiste en agarrar primero el nodo izquierdo, luego la raiz de ella y luego el derecho.
     */
    public void inOrder(BinaryTreeNode <T> node) {
        if (node != null) {
            inOrder(node.leftSon);
            System.out.println("                          { " + node.data + " }");
            inOrder(node.rightSon);
        }
    }

    /*
     * Metodo postOrder.
     * Consiste en agarrar primero el nodo izquierdo, luego el derecho de ella y luego la raiz.
     */
    public void postOrder(BinaryTreeNode <T> node) {
        if (node != null) {
            postOrder(node.leftSon);
            postOrder(node.rightSon);
            System.out.println("                          { " + node.data + " }");
        }
    }

    /*
     * Busca el nodo.
     */
    public BinaryTreeNode <T> searchNode(BinaryTreeNode <T> node, int data) {
        if (node == null) {
            return null;
        } 
        else {
            if (node.data == data) {
                return node;
            } 
            else {
                if (node.data < data) {
                    return searchNode(node.rightSon, data);
                } 
                else {
                    return searchNode(node.leftSon, data);
                }
            }
        }
    }
 
    /*
     * Inserta el nodo recursivamente.
     */
    public BinaryTreeNode <T> addRecursive(BinaryTreeNode <T> node, int data, BinaryTreeNode <T> father) {
        BinaryTreeNode <T> newNode = new BinaryTreeNode(data);
        if (isEmpty()) {
            setRoot(newNode);
        }
        else {
            if (node == null) {
                newNode.setFather(father);
                return newNode;
            }
            else {
                if (node.data > data) {
                    node.setLeftSon(addRecursive(node.leftSon, data, node));
                }
                else {
                    node.setRightSon(addRecursive(node.rightSon, data, node));
                }
            }
        }
        return node;
    }

    /*
     * Añade el nodo.
     */
    public void add(BinaryTreeNode <T> node, int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        BinaryTreeNode aux = node;
        if (isEmpty()) {
            setRoot(newNode);
        } else {
            while (true) {
                if (aux.data > data) {
                    if (aux.leftSon == null) {
                        aux.setLeftSon(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.leftSon;
                    }
                } else {
                    if (aux.rightSon == null) {
                        aux.setRightSon(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.rightSon;
                    }
                }
            }
        }
    }

    /*
     * Borra el nodo.
     */
    public void delete(BinaryTreeNode <T> node, int data) {
        if (node != null) {
            
            if (node.data == data) {
                System.out.println("The following Node is being deleted: " + data + "\n");
                if (node.leftSon == null && node.rightSon == null) {
                    // Es una Hoja
                    if (node.father.leftSon.data == data) {
                        node.father.setLeftSon(null);
                    } 
                    else {
                        node.father.setRightSon(null);
                    }
                    node.setFather(null);
                    
                } 
                else if (node.leftSon == null) {
                    // Solo Tiene hijo derecho
                    if (node.father.leftSon.data == data) {
                        node.father.setLeftSon(node.rightSon);
                    } else {
                        node.father.setRightSon(node.getRightSon());
                    }
                    node.setRightSon(null);
                    node.setFather(null);
                    
                } 
                else if (node.getRightSon() == null) {
                    // Solo Tiene hijo izquierdo
                    if (node.father.leftSon.data == data) {
                        node.father.setLeftSon(node.leftSon);
                    } 
                    else {
                        node.father.setRightSon(node.leftSon);
                    }
                    node.setLeftSon(null);
                    node.setFather(null);
                    
                } 
                else {
                    // Tiene dos hijos
                    BinaryTreeNode <T> newNode = searchMin(node.rightSon);
                    if (node.father.leftSon.data == data) {
                        newNode.setLeftSon(node.leftSon);
                        
                        if (node.rightSon.data != newNode.data) {
                            newNode.setRightSon(node.rightSon);
                        }
                        
                        newNode.father.setLeftSon(null);
                        newNode.setFather(node.father);
                        node.father.setLeftSon(newNode);
                        
                    } 
                    else {
                        newNode.setLeftSon(node.leftSon);
                        if (node.rightSon.data != newNode.data) {
                            newNode.setRightSon(node.rightSon);
                        }
                        
                        newNode.father.setLeftSon(null);
                        newNode.setFather(node.getFather());
                        node.father.setRightSon(newNode);
                        
                    }
                    
                    node.setFather(null);
                    node.setLeftSon(null);
                    node.setRightSon(null);
                }
            } 
            else if (node.getData() < data) {
                delete(node.getRightSon(), data);
            } 
            else {
                delete(node.getLeftSon(), data);
            }
        }
        else{
            System.out.println("The node was not found.");
        }

    }

    /*
     * Buscar mínimo.
     */
    public BinaryTreeNode <T> searchMin(BinaryTreeNode <T> node) {
        while (node.leftSon != null) {
            node = node.leftSon;
        }
        return node;
    }

    /*
     * Buscar mayor.
     */
    public BinaryTreeNode <T> searchMay(BinaryTreeNode <T> node) {
        while (node.rightSon != null) {
            node = node.rightSon;
        }
        return node;
    }
    
    /*
     * Suma los nodos.
     */
    public int sumNodes(BinaryTreeNode <T> node){
        if (node != null) {
            int sum1 = sumNodes(node.leftSon);
            int sum2 = sumNodes(node.rightSon) + node.data;
            return (sum1 + sum2);
        }
        return 0;
    }

    /*
     * Cuenta los nodos.
     */
    public int countNodes(BinaryTreeNode <T> node) {
        int count = 0;
        if (node != null){
            count = 1 + countNodes(node.leftSon) + countNodes(node.rightSon);
        }
        return count;
    }
    
    /*
     * Obtiene el peso.
     */
    public int weight(BinaryTreeNode <T> node){
        if (node == null) {
            return 0;
        }
        int leftSize = weight(node.leftSon);
        int rightSize = weight(node.rightSon);
        return leftSize + rightSize + 1; 
    }
    
    /*
     * Obtiene la altura.
     */
    public int height (BinaryTreeNode <T> node){
        if (node != null) {
            return 1 + Math.max(height(node.leftSon),height(node.rightSon));
        }
        return 0;
    }
  
    /*
     * Obtiene el nivel del nodo.
     */
    public int nodeLevel(BinaryTreeNode <T> node, int key) {
        return nodeLevelHelper(node, key, 1);
    }

    /*
     * Ayuda nivel del nodo.
     */
    private int nodeLevelHelper(BinaryTreeNode <T> node, int key, int level) {
        if (node == null) {
            return -1;
        }
        if (node.data == key) {
            return level;
        }
        int leftLevel = nodeLevelHelper(node.leftSon, key, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return nodeLevelHelper(node.rightSon, key, level + 1);
    }

    /*
     * Verifica si está balanceado.
     */
    public boolean isBalanced(BinaryTreeNode <T> node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.leftSon);
        int rightHeight = height(node.rightSon);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(node.leftSon) && isBalanced(node.rightSon);
    }

    /*
     *  Elimina los nodos.
     */
    public BinaryTreeNode removeNodes(BinaryTreeNode <T> node) {
        if (node == null) {
            return null;
        }
        if (node.leftSon == null && node.rightSon == null) {
            return null;
        }
        node.leftSon = removeNodes(node.leftSon);
        node.rightSon = removeNodes(node.rightSon);
        return node;
        
    }

    /*
     * Elimina árboles.
     */
    public BinaryTreeNode removeTrees(BinaryTreeNode <T> node, int value) {
        if (node == null) {
            return null;
        }
        if (node.leftSon == null && node.rightSon == null && node.data == value) {
            return null;
        }
        node.leftSon = removeTrees(node.leftSon, value);
        node.rightSon = removeTrees(node.rightSon, value);
        if (node.leftSon == null && node.rightSon == null && node.data == value) {
            return null; 
        }
        return node;
    }
    
    /*
     * Obtiene los nodos repetidos.
     */
    public LinkedList repeatedNodes(BinaryTreeNode <T> node1, BinaryTreeNode <T> node2) {
        LinkedList out = new LinkedList();
        if(node1 != null && node2 != null){
            if((int) node1.getData() == this.commonValues(node1, node2)){
                out.add(node1.data);               
            }
            else{
                repeatedNodes(node1.leftSon, node2);
                repeatedNodes(node1.rightSon, node2);
            }
            
        }
        return out;
    }

    /*
     * Verifica si los nodos son iguales.
     */
    public int commonValues(BinaryTreeNode <T> node1, BinaryTreeNode <T> node2) {
        if(root == null && node2 == null){
            System.out.println("Empty.");
            return 1;
        }
        else if(node1 == null && node2 != null){
            return 0;
        }
        else if(node1 != null && node2 == null){
            return 0;
        }
        else{
            if( node1.data ==  node2.data){
                System.out.println("The following Node is in both trees: " + node1.data);
                return node1.data;
                
            }
            else if( node1.data <  node2.data){
                commonValues(node1, node2.leftSon);
                
            }
            else if( node1.data >  node2.data){
                commonValues(node1, node2.rightSon);
            }
        }
        return 0;
    }

    /*
     * Verifica si el nodo está presente.
     */
    public boolean isNodePresent(BinaryTreeNode <T> root, BinaryTreeNode <T> node){
            if (root == null) {
                return false;
            }
            if (root == node) {
                return true;
            }
            return isNodePresent(root.leftSon, node) || isNodePresent(root.rightSon, node);
        }

    /*
     * Obtiene el ancestro de común entre nodos.
     */
    public BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> root, int value1, int value2) {
    if (root == null) {
        return null;
    }
    else if (root.getData() == value1 || root.getData() == value2) {
        return root;
    }
    BinaryTreeNode<T> left = lowestCommonAncestor(root.getLeftSon(), value1, value2);
    BinaryTreeNode<T> right = lowestCommonAncestor(root.getRightSon(), value1, value2);
    if (left != null && right != null) {
        System.out.println("El ancestro es: " + root.getData());
        return root;
    }
    else{
        if (left != null || right != null) {
            return left;
        }
        else if (right != null) {
            return right;
        }
    }
    return null;
}

}


