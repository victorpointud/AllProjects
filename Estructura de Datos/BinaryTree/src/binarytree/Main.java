package binarytree;

/*
 * @author victorpointud
 */

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();

        tree.addRecursive(tree.root, 80, tree.root);
        tree.addRecursive(tree.root, 52, tree.root);
        tree.addRecursive(tree.root, 1, tree.root);
        tree.addRecursive(tree.root, 69, tree.root);
        tree.addRecursive(tree.root, 73, tree.root);
        tree.addRecursive(tree.root, 46, tree.root);
        tree.addRecursive(tree.root, 38, tree.root);
        tree.addRecursive(tree.root, 0, tree.root);
        tree.addRecursive(tree.root, 99, tree.root);
        tree.addRecursive(tree.root, 66, tree.root);
        
        tree2.addRecursive(tree2.root, 12, tree2.root);
        tree2.addRecursive(tree2.root, 52, tree2.root);
        tree2.addRecursive(tree2.root, 99, tree2.root);
        tree2.addRecursive(tree2.root, 35, tree2.root);
        tree2.addRecursive(tree2.root, 46, tree2.root);
        tree2.addRecursive(tree2.root, 0, tree2.root);
        tree2.addRecursive(tree2.root, 55, tree2.root);
        tree2.addRecursive(tree2.root, 98, tree2.root);

        /*
        * Metodo inOrder llamado y despues se borra un elemento con delete.
        */
        System.out.println("\n************************* IN ORDER ************************\n");
        System.out.println("TREE 1");
        tree.inOrder(tree.root);
        System.out.println("TREE 2");
        tree2.inOrder(tree2.root);
        System.out.println("\n***********************************************************\n");
        tree.delete(tree.root, 38);
        tree2.delete(tree2.root, 99);
        System.out.println("***********************************************************\n");
        System.out.println("TREE 1");
        tree.inOrder(tree.root);
        System.out.println("TREE 2");
        tree2.inOrder(tree2.root);

        /*
        * Metodo preOrder llamado y despues se borra un elemento con delete.
        */
        System.out.println("\n************************ PRE ORDER ************************\n");
        System.out.println("TREE 1");
        tree.preOrder(tree.root);
        System.out.println("TREE 2");
        tree2.preOrder(tree2.root);
        System.out.println("\n***********************************************************\n");
        tree.delete(tree.root, 69);
        tree2.delete(tree2.root, 52);
        System.out.println("***********************************************************\n");
        System.out.println("TREE 1");
        tree.preOrder(tree.root);
        System.out.println("TREE 2");
        tree2.preOrder(tree2.root);

        /*
        * Metodo postOrder llamado y despues se borra un elemento con delete.
        */
        System.out.println("\n*********************** POST ORDER ************************\n");
        System.out.println("TREE 1");
        tree.postOrder(tree.root);
        System.out.println("TREE 2");
        tree2.postOrder(tree2.root);
        System.out.println("\n***********************************************************\n");
        tree.delete(tree.root, 99);
        tree2.delete(tree2.root, 98);
        System.out.println("***********************************************************\n");
        System.out.println("TREE 1");
        tree.postOrder(tree.root);
        System.out.println("TREE 2");
        tree2.postOrder(tree2.root);

        /*
        * Metodo lowestCommonAncestor llamado.
        */
        System.out.println("\n****************** LOWEST COMMON ANCESTOR *******************\n");
        tree.lowestCommonAncestor(tree.root, 73, 1);
        
        /*
        * Metodo weight llamado.
        */
        System.out.println("\n************************* WEIGHT **************************\n");
        System.out.println("The weight of this tree 1 is: " + tree.weight(tree.root));
        System.out.println("The weight of this tree 2 is: " + tree2.weight(tree2.root));

        /*
        * Metodo nodesCount llamado.
        */      
        System.out.println("\n********************** NODES COUNT ************************\n");
        System.out.println("The total nodes count in the tree 1 is: " + tree.countNodes(tree.root));
        System.out.println("The total nodes count in the tree 2 is: " + tree2.countNodes(tree2.root));

        /*
        * Metodo nodesSum llamado.
        */   
        System.out.println("\n*********************** NODES SUM *************************\n");
        System.out.println("The total nodes sum in the tree 1 is: " + tree.sumNodes(tree.root));
        System.out.println("The total nodes sum in the tree 2 is: " + tree2.sumNodes(tree2.root));

        /*
        * Metodo height llamado.
        */   
        System.out.println("\n************************* HEIGHT **************************\n");
        System.out.println("The height of the tree 1 is: " + tree.height(tree.root));
        System.out.println("The height of the tree 2 is: " + tree2.height(tree2.root));

        /*
        * Metodo nodeLevel llamado.
        */   
        System.out.println("\n*********************** NODE LEVEL ************************\n");
        System.out.println("The height of the node is: " + tree.nodeLevel(tree.root, 1));

        /*
        * Metodo isBalanced llamado.
        */   
        System.out.println("\n*********************** IS BALANCED ***********************\n");
        System.out.println("The tree is balanced?: " + tree.isBalanced(tree.root));
        System.out.println("The tree is balanced?: " + tree2.isBalanced(tree2.root));
        
        /*
        * Metodo removeTrees llamado.
        */   
        System.out.println("\n********************** REMOVE TREES ***********************\n");
        tree.removeTrees(tree.root, 1);
        System.out.println("TREE 1");
        tree.postOrder(tree.root);
        System.out.println("TREE 2");
        tree2.removeTrees(tree2.root, 1);
        tree2.postOrder(tree2.root);

        /*
        * Metodo removeNodes llamado.
        */   
        System.out.println("\n********************** REMOVE NODES ***********************\n");
        tree.removeNodes(tree.root);
        System.out.println("TREE 1");
        tree.postOrder(tree.root);
        tree2.removeNodes(tree2.root);
        System.out.println("TREE 2");
        tree2.postOrder(tree2.root);

        /*
        * Metodo repeatedNodes llamado.
        */   
        System.out.println("\n********************* REPEATED NODES **********************\n");
        // No se imprime nada porque el removeNodes lo borra, pero si comento removeNodes si imprime.
        tree.repeatedNodes(tree.root, tree2.root);
        System.out.println("\n***********************************************************\n");
    
    
    }
   
}

