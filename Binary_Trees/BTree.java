package Binary_Trees;

public class BTree {
    
    static class  Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1 ;

        public static Node buildTree(int preOrder[]) {
            idx++;

            if (preOrder[idx] == -1 ) {
                return null;
            }

            Node newNode = new Node(preOrder[idx]);
            newNode.left = buildTree(preOrder);
            newNode.right = buildTree(preOrder);

            return newNode;
        }

        // PreOrder Traversal 

        public static void preOrder(Node root) {
            
            if (root == null) {
                // System.out.print(-1 + " ");
                 return;
            }
            System.out.print( root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String[] args) {
        int preOrder[] = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(preOrder);
        // System.out.println(root);

         tree.preOrder(root);

    }
}
