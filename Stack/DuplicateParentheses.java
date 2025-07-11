package Stack;

import java.util.Stack;

public class DuplicateParentheses {
    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {        //closing
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {    // opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b))"; // True, duplicate exists
        String str2 = "(a+b)"; // false, duplicate doesnt exists
        System.out.println(isDuplicateParentheses(str1));

    }
}
