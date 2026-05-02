package Graphs;

public class MinDepthBTree {

    static class Node {
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

        public static Node buildTree(int Nodes[]) {
            idx++;

            if (Nodes[idx] == -1 ) {
                return null;
            }

            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildTree(Nodes);
            newNode.right = buildTree(Nodes);

            return newNode;
        }
    }

    static int min = Integer.MAX_VALUE;

    public static void dfs(Node curr, int level) {

        if ( curr == null ) {
            return ;
        }

        if ( curr.left == null && curr.right == null ){
            min = Math.min(min, level);
            return;
        }

        dfs(curr.left, level+1);
        dfs(curr.right, level+1);
    }

    public static int minDepth(Node root) {
        if ( root == null ) {
            return 0;
        }

        min = Integer.MAX_VALUE;

        dfs(root, 1);

        return min;
    }

    public static void main(String[] args) {
        int Nodes[] = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(Nodes);

        System.out.println("Min Depth = " + minDepth(root));
    }
}
