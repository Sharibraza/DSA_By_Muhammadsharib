package Binary_Trees;
import java.util.LinkedList;
import java.util.Queue;

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

        // 1. PreOrder Traversal - O(n) 1 2 3 4 5

        public static void preOrder(Node root) {

            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }


        // 2. Inorder Traversal - O(n) 2 1 4 3 5

        public static void inOrder(Node root) {

            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        // 3. PostOrder Traversal - O(n) 2 4 5 3 1

        public static void postOrder(Node root) {

            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // 4. Level order Traversal - O(n) 1 2 3 4 5

        public static void levelOrder(Node root) {

            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
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
