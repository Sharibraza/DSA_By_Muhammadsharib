package Binary_Trees.BST;

import Binary_Trees.BST.Bst.*;

public class DelFromBST {

    public static void preOrder(Node root) {

            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
    public static Node delete(Node root, int val){
        
        if ( root.data > val) { 
            root.left = delete(root.left, val);
        }
        else if ( root.data < val ) {
            root.right = delete(root.right, val);
        } // root.data == val | wo Node jisko del karna hai
        else{

            // Case 1 : leaf Node
            if ( root.left == null && root.right == null ) {
                return null;
            }

            // Case 2 : single Node
            if ( root.left == null ) {      // R->r  Lx
                return root.right;
            }else if (root.right == null){  // R->L  rx
                return root.left;
            }

            // Case 3 : Two Child

            Node IS = findInorderSuccessor(root.right);  // why R.right --> bcz we know inorder succ.. will exist in right Subtree
            root.data = IS.data;                         // replace root val by Ins
            root.right = delete(root.right, IS.data);    // del IS Node
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        // agar root hi null huwa to? --> yaha root kabhi null ho hi nahi sakta, bcz ye case hamne upar handle kiya hai (// R->L  rx)
        while ( root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
      int val[] = {8,5,10,3,6,1,4,11,14};
      Node root = null ;

      for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        Bst.inOrder(root);
        System.out.println();

        delete(root, 5);

        preOrder(root);

         // 1. Compile : javac Bst.java DelFromBST.java
        // 2. Run : java DelFromBST.java
    }
}
