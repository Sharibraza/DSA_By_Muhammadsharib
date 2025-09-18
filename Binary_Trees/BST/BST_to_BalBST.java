package Binary_Trees.BST;

import java.util.ArrayList;

import Binary_Trees.BST.Bst.*;


public class BST_to_BalBST {
    
    public static void inOrder(Node root, ArrayList<Integer> list ){
        
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static Node bstToBalBst(Node root, ArrayList<Integer> list, int start, int end){
        
        if (start > end) {
            return null;
        }
        int mid = (start+end) / 2 ;
        root = new Node(list.get(mid)) ;
        root.left = bstToBalBst(root.left, list, start, mid-1);
        root.right = bstToBalBst(root.right, list, mid+1, end);

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
        
        int val[] = {6,5,3,8,10,11,12};
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        ArrayList<Integer> list = new ArrayList<>() ;
        inOrder(root, list);

        root =  bstToBalBst(root,list,0,list.size()-1);

        preOrder(root);
        
         // 1. Compile : javac Bst.java BST_to_BalBST.java
        // 2. Run : java BST_to_BalBST.java
    }
}
