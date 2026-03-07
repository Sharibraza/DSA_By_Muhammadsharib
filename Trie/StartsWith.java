package Trie;

public class StartsWith {

    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ //O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static boolean isStartsWith(String prefix){  // O(L)- length of prefix
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "man";
        String prefix3 = "sam";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(isStartsWith(prefix1));
        System.out.println(isStartsWith(prefix2));
        System.out.println(isStartsWith(prefix3));
    }
}
