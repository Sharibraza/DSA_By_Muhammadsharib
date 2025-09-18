package Binary_Trees.BST;

import java.util.ArrayList;

import Binary_Trees.BST.Bst.*;

public class Merge2BST {

    public static void getInorder(Node root, ArrayList<Integer> bstList) {

        if (root == null) {
            return;
        }
        getInorder(root.left, bstList);
        bstList.add(root.data);
        getInorder(root.right, bstList);
    }

    public static Node createBST(ArrayList<Integer> arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, s, mid - 1);
        root.right = createBST(arr, mid + 1, e);

        return root;
    }

    public static Node mergeBsts(Node root1, Node root2) {
        // Inorder seq for BST1
        ArrayList<Integer> bst1List = new ArrayList<>();
        getInorder(root1, bst1List);

        // Inorder seq for BST1
        ArrayList<Integer> bst2List = new ArrayList<>();
        getInorder(root2, bst2List);

        // Merge Bst1 and Bst2
        ArrayList<Integer> finalBstList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < bst1List.size() && j < bst2List.size()) {
            if (bst1List.get(i) <= bst2List.get(j)) {
                finalBstList.add(bst1List.get(i));
                i++;
            } else {
                finalBstList.add(bst2List.get(j));
                j++;
            }
        }
        while (i < bst1List.size()) {
            finalBstList.add(bst1List.get(i));
            i++;
        }
        while (j < bst2List.size()) {
            finalBstList.add(bst2List.get(j));
            j++;
        }

        // sorted list --> BST
       return createBST(finalBstList, 0, finalBstList.size()-1);
    }

    public static void preOrder(Node root){
        if (root == null) {
            return ;
        }
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        //O(n+m) ---> Linear
        Node root = mergeBsts(root1, root2);

        preOrder(root);

          // 1. Compile : javac Bst.java Merge2BST.java
        // 2. Run : java Merge2BST.java
    
    }
}
