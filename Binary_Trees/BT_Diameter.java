package Binary_Trees;

import Binary_Trees.BTree.Node;

public class BT_Diameter {

    // Approach 1 : O(n^2) ---> har ek node pw height seprately calculate karna padh
    // rahi hai
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDia = diameter(root.left);
        int leftHeight = HeightOfBTree.height(root.left);

        int rightDia = diameter(root.right);
        int rightHeight = HeightOfBTree.height(root.right);

        int selfDia = leftHeight + rightHeight + 1;

        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }

    // Approach 2 : O(n)

    static class Info {
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diam, height);

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // System.out.println("Dia of tree: " + diameter(root)); Approach 1
        System.out.println("Dia of tree: " + diameter2(root).diam); // Approach 2

        // 1. Complile :- javac Binary_Trees/*.java
        // 2. Run :- java Binary_Trees.BT_Diameter
    }
}
