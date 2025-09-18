package Binary_Trees.BST;

import Binary_Trees.BST.Bst.*;
public class BalancedBST {
    
    public static Node createBalBst(int arr[], int start, int end){
        
        if ( start > end) {
            return null;
        }

        int mid = (start + end )/ 2 ;
        Node root = new Node(arr[mid]);

        root.left = createBalBst(arr, start, mid-1);
        root.right = createBalBst(arr, mid+1, end);

        return root;
    }

     public static void preOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        int arr[] = {2,5,6,8,10,11,12};


        Node root = createBalBst(arr, 0, arr.length-1);
        preOrder(root);
       
         // 1. Compile : javac Bst.java BalancedBST.java
        // 2. Run : java BalancedBST.java
    }
}
