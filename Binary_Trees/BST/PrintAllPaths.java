package Binary_Trees.BST;

import java.util.ArrayList;

import Binary_Trees.BST.Bst.*;

public class PrintAllPaths {

    public static void printPaths( ArrayList<Integer> paths){
        for (int i = 0; i < paths.size(); i++) {
                System.out.print(paths.get(i) + "->");
            }
            System.out.println("Null");
    }
    
    public static void printRoot2Leaf(Node root, ArrayList<Integer> paths){
        
        if (root == null) {
            return;
        }

        paths.add(root.data);

        if (root.left ==null && root.right == null) {
            printPaths(paths);
        }
        
        printRoot2Leaf(root.left, paths);
        printRoot2Leaf(root.right, paths);

        paths.remove(paths.size()-1);

    }

    public static void main(String[] args) {
         int val[] = {8,5,3,6,10,11,14};
         Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Bst.buildBST(root, val[i]);
        }

        printRoot2Leaf(root,new ArrayList<>());


         // 1. Compile : javac Bst.java PrintAllPaths.java
        // 2. Run : java PrintAllPaths.java
    }
}
