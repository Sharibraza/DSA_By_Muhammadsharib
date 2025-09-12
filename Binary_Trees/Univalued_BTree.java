package Binary_Trees;

import Binary_Trees.BTree.Node;

public class Univalued_BTree {

    public static boolean isUniVal(Node root) {

        if (root == null) {
            return true;
        }

        if ( root.left != null && root.data != root.left.data) {
            return false;
        }

         if ( root.right != null && root.data != root.right.data) {
            return false;
        }
        
        return isUniVal(root.left) && isUniVal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);

        if (isUniVal(root)) {
            System.out.println( "YES");
        } else {
            System.out.println("NO");
        }

    }
}
