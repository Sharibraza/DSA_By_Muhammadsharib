package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

import Binary_Trees.BTree.Node;

public class Kth_level_Ele {

    // Approach 1 :- ( Iterative ), Level order Traversal
    // public static void kthlevel(Node root, int k) {
    // int level =0;

    // Queue<Node> q = new LinkedList<>();
    // q.add(root);
    // q.add(null);

    // while (!q.isEmpty()) {
    // Node currNode = q.remove();

    // if (level / 2 == k) {
    // while (!q.isEmpty()) {
    // Node d = q.remove();
    // System.out.print(d.data + " ");
    // }
    // }

    // if (currNode == null) {
    // System.out.println();
    // if (q.isEmpty()) {
    // break;
    // } else {
    // q.add(null);
    // }
    // } else {

    // if (currNode.left != null) {
    // q.add(currNode.left);
    // }
    // if (currNode.right != null) {
    // q.add(currNode.right);
    // }
    // }
    // level++;
    // }
    // }

    // Approach 2 :- ( Recursive ), PreOrder Traversal
    public static void kthlevel(Node root, int level, int k) {

        if (root == null)
            return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthlevel(root.left, level + 1, k);
        kthlevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {

         /*
            1
           / \
          2  3
         / \ / \
         4 5 6 7
         
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;

        // kthlevel(root, k);
        kthlevel(root,0,k);

        // javac Btree.java Kth_level_Ele.java

    }
}
