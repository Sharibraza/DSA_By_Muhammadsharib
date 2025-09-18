package Binary_Trees.BST;

import Binary_Trees.BST.Bst.*;

public class ValidBST {

    public static boolean isValid(Node root, Node min, Node max) {

        if (root == null) {
            return true;
        }

        if ( min != null && root.data <= min.data ) {  //Right SubTree
            return false;
        }
        else if ( max != null &&  root.data >= max.data) {  //Left SubTree
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static void main(String[] args) {
        int val[] = { 1,1,1};
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        if (isValid(root, null, null)) {
            System.out.println("Valid");
        }else{
            System.out.println("Not Valid");
        }

         // 1. Compile : javac Bst.java ValidBST.java
        // 2. Run : java ValidBST.java
    }
}
