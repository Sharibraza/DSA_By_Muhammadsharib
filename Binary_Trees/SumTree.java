package Binary_Trees;

import Binary_Trees.BTree.Node;
import Binary_Trees.BTree.BinaryTree;

public class SumTree {
    
    public static int transform(Node root){
        
        if ( root == null ) {
            return 0;
        }

        int leftSubtreeSum = transform(root.left);
        int rightSubtreeSum = transform(root.right);

        int data = root.data;
        int newLeft =  root.left == null ? 0 :  root.left.data ;    // for Leaf Node == null 
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftSubtreeSum + newRight  + rightSubtreeSum ;

        return data;
    }


    
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);

       BinaryTree.preOrder(root);

       // 1. Compile : javac BTree.java SumTree.java
       // 2. Run : java SumTree.java
    }
}
