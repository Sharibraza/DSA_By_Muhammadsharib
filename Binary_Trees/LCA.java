package Binary_Trees;

import java.util.ArrayList;

import Binary_Trees.BTree.Node;

public class LCA {
    
    // Approach 1 : - O(n) , O(n) --> app2
    // public static boolean getPath(Node root, int n, ArrayList<Node> path){
    //      if (root == null) {
    //         return false;
    //      }

    //      path.add(root);

    //      if (root.data == n) {
    //         return true;
    //      }

    //      boolean foundLeft = getPath(root.left, n, path);
    //      boolean foundRight = getPath(root.right, n, path);

    //      if ( foundLeft || foundRight) {
    //         return true;
    //      }

    //      path.remove(path.size()-1);
    //      return false;
    // }

    // public static Node lca(Node root, int n1, int n2){
        
    //     ArrayList<Node> path1 = new ArrayList<>();
    //     ArrayList<Node> path2 = new ArrayList<>();

    //     getPath(root,n1,path1); // Path of n1
    //     getPath(root,n2,path2);  // Path of n2

    //     // Last Common ancestor
    //     int i = 0 ;
    //     for (; i < path1.size() && i< path2.size() ; i++) {
    //         if (path1.get(i) != path2.get(i)) {
    //             break;
    //         }
    //     }

    //     // Last equal Node --> i-1th
    //     Node lca = path1.get(i-1);
    //     return lca;
    // }

    // Approach 2 : - O(n) , O(1)
    public static Node lca(Node root, int n1, int n2){

        if (root == null ) {
            return root; // empty tree
        }

        if ( root.data == n1 || root.data == n2 ) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca =lca(root.right, n1, n2);

        //  leftLca (leftsubtree) == val  and  rightLca == null 
        if (rightLca == null) {
            return leftLca;
        }

        //  rightLca == val and leftLca == null
        if (leftLca == null) {
            return rightLca;
        }

          return root; //if (leftLca != null && rightLca != null)
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;

        System.out.print(lca(root,n1,n2).data);

        // 1. Compile : javac BTree.java LCA.java
        // 2. Run : java LCA.java
    }
}
