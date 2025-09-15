package Binary_Trees.BST;

import Binary_Trees.BST.Bst.*;

public class PrintinRange {

    public static void print(Node root, int k1, int k2){
        
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
           print(root.left, k1, k2);
           System.out.print(root.data + " "); 
           print(root.right, k1, k2);
        }
        else if ( root.data > k1) {  // That means the node is too large or just outside the range on the higher side.If root.data > k1, then there might still be smaller values in the left subtree that fall into the range.
            print(root.left, k1, k2);
        }else{
            print(root.right, k1, k2); //That means the node is too small.So, all smaller values in its left subtree are definitely < k1 (too small).
        }

    }

    public static void main(String[] args) {
        int val[] = { 8, 5, 10, 3, 6, 1, 4, 11, 14 };
        Node root = null;
        int k1 = 5, k2 = 12;

        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        print(root, k1, k2);

         // 1. Compile : javac Bst.java PrintinRange.java
        // 2. Run : java PrintinRange.java
    }
}
