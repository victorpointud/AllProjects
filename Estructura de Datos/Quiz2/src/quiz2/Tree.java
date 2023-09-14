
package quiz2;

/**
 *
 * @author victorpointud
 */

public class Tree {
    NodeTree root;
    int id;
    
    public Tree(int id){
        this.root = null;
        this.id = id;
    }

    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void insertData(int data) {
        
        NodeTree root = this.getRoot();
        NodeTree newNode = new NodeTree(data, this.getId());
        NodeTree aux = root;
        if (isEmpty()) {
            setRoot(newNode);
        } else {
            while (true) {
                if (aux.getData() > data) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.getRight();
                    }
                }
            }
        }
    }
    
    public boolean isEmpty(){
        return getRoot() == null;
    }
    
    public void preOrder(NodeTree root) {
        if (root != null) {
            System.out.println("                          { " + root.getData() + " }");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void descompressTree(NodeTree root, List treeList) {
        if(root != null){
            descompressTree(root.getLeft(), treeList);
            treeList.insert(root.getData());
            descompressTree(root.getRight(),treeList);
        }
    }
    
        public void insertNode(NodeTree newNode) {
        
        NodeTree root = this.getRoot();
        NodeTree aux = root;
        
            while (true) {
                if (aux.getData() > newNode.getData()) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(newNode);
                        newNode.setFather(aux);
                        break;
                    } else {
                        aux = aux.getRight();
                    }
                }
            }
        
    }

    public List mix(List treeList) {
        
            NodeList pointer = treeList.getHead();
        
        while (pointer.getNext() != null){
            
            NodeTree newNode = new NodeTree(pointer.getElement(),pointer.getIndex());
            
            NodeTree root = this.getRoot();
            NodeTree aux = root;
        
            while (true) {
                
                if (aux.getData() > newNode.getData()) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(newNode);
                        newNode.setFather(aux);
                        treeList.delete(pointer);
                        break;
                    } else {
                        aux = aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(newNode);
                        newNode.setFather(aux);
                        treeList.delete(pointer);
                        break;
                    } else {
                        aux = aux.getRight();
                    }
                }
            }
            
            pointer = pointer.getNext();
            
        }
        return treeList;
    }
    
    public void preOrderStr(NodeTree root,String str) {
        if (root != null) {
            str.concat("{ " + root.getData() + " }");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
        System.out.println(str);
    }
}
