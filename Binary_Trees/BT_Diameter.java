package Binary_Trees;
import Binary_Trees.HeightOfBTree;
import Binary_Trees.BTree.Node;

public class BT_Diameter {
    
     public static int diameter(Node root) {
        if (root == null ) {
            return 0;
        }

        int leftDia = diameter(root.left);
        int leftHeight = HeightOfBTree.height(root.left);

        int rightDia = diameter(root.right);
        int rightHeight = HeightOfBTree.height(root.right);

        int selfDia = leftHeight + rightHeight + 1 ;

        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Dia of tree: " + diameter(root));

        // 1. Complile :- javac Binary_Trees/*.java
        // 2. Run :- java Binary_Trees.BT_Diameter
    }
}
