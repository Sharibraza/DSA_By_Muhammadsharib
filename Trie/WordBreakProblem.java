package Trie;

public class WordBreakProblem {

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            if (Trie_Code.search(key.substring(0, i))
                    && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for (int i = 0; i < words.length; i++) {
            Trie_Code.insert(words[i]);
        }

        String key1 = "samsung";
        String key2 = "phone";

        System.out.println(wordBreak(key1));
        System.out.println(wordBreak(key2));

    }
}
