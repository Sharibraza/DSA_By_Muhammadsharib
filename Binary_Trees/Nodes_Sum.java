package Binary_Trees;
import Binary_Trees.BTree.Node;

public class Nodes_Sum {

    public static int sumOfNodes(Node root) {
        
         if ( root == null ) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        int sum = leftSum + rightSum + root.data;

        return sum ;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Nodes of Binary Tree : " + sumOfNodes(root) );

        // 1. Complile :- javac Binary_Trees/*.java
        // 2. Run :- java Binary_Trees.NodesCount
    }
}
