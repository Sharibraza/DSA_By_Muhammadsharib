package Binary_Trees;

import Binary_Trees.BTree.Node;
import java.util.HashMap;

public class DuplicateSubtrees {

    static HashMap<String, Integer> m;

    public static String printInorder(Node node) {

        if (node == null) {
            return "";
        }

        String str = "(";
        str += printInorder(node.left);
        str += Integer.toString(node.data);
        str += printInorder(node.right);
        str += ")";

        if (m.get(str) != null && m.get(str) == 1) {
            System.out.print(node.data + " ");
        }

        if (m.containsKey(str)) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }
        
        return str;
    }

    public static void printAllDups(Node root) {

        m = new HashMap<>();
        printInorder(root);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}
