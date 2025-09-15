package Binary_Trees.BST;

import Binary_Trees.BST.Bst;
import Binary_Trees.BST.Bst.Node;

public class SearchIn_Bst {

    public static boolean search(Node root, int key) {  // O(h)

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if ( root.data > key) {
           return search(root.left, key);
        }else{
            return search(root.right, key);
        }

    }

    public static void main(String[] args) {
        int val[] = { 5, 1, 3, 4, 6, 10, 8, 11, 14 };
        Node root = null;
        int key = 22;
        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        System.out.println(search(root, key));

         // 1. Compile : javac Bst.java SearchIn_Bst.java
        // 2. Run : java SearchIn_Bst.java
    }
}
