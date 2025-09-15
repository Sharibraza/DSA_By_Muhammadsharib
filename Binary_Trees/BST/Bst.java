package Binary_Trees.BST;

public class Bst {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) { // Go Left
            root.left = buildBST(root.left, val);
        } else { // Go Right
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root){
        if ( root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int val[] = {5,1,3,4,2};
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = buildBST(root, val[i]);
        }
       
        inOrder(root);
    }
}
