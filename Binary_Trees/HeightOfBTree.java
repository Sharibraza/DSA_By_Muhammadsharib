package Binary_Trees;
import Binary_Trees.BTree.Node;;


public class HeightOfBTree {
    
    public static int height(Node root) {
        
        if ( root == null ) return 0 ;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int treeHeight = Math.max(leftHeight, rightHeight) + 1 ;

        return treeHeight;
    }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

    }
}
