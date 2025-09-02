package Binary_Trees;
import Binary_Trees.BTree.Node;

public class NodesCount {
    
    public static int count(Node root) {
        
        if ( root == null ) return 0;

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        int nodesCount = leftCount + rightCount + 1 ;

        return nodesCount;
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Nodes of Binary Tree : " + count(root) );

        // 1. Complile :- javac Binary_Trees/*.java
        // 2. Run :- java Binary_Trees.NodesCount
    }
}
