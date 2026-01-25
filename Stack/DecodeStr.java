package Stack;

import java.util.Stack;

public class DecodeStr {

    // Bruteforce : My approach ( has many flaws )
    // public static StringBuilder decode(String codedMsg){
    //     Stack<Character> s = new Stack<>();
    //     StringBuilder code = new StringBuilder();
    //     for (int i = 0; i < codedMsg.length(); i++) {
    //         char ch = codedMsg.charAt(i);
    //         if ( ch == ']') {
    //             while ( s.peek() != '[' ) {
    //                 code.append( s.pop() );
    //             }
    //             s.pop();  // pop [
    //             code.reverse();
    //             code.repeat(code, s.pop() - '0' - 1 );  // multiplying str with num                
    //         }else{
    //             s.push(ch);
    //         }
    //     }
    //     return  code;
    // }

    // 2. optimized , handles mul edge cases
    public static String decode(String str) {

        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerstack.push(count);
            } else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if (!integerstack.isEmpty()) {
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while (!stringstack.isEmpty() && stringstack.peek() != '[') {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
                if (!stringstack.empty() && stringstack.peek() == '[') {
                    stringstack.pop();
                }
                for (int j = 0; j < count; j++) {
                    result = result + temp;
                }
                for (int j = 0; j < result.length(); j++) {
                    stringstack.push(result.charAt(j));
                }
                result = "";
            } else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    stringstack.push(str.charAt(i));
                } else {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            } else {
                stringstack.push(str.charAt(i));
            }
        }
        while (!stringstack.isEmpty()) {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String codedMsg = " 3[b2[v]]L ";// 1. "2[cv]"  2. "3[b2[v]]L" 3."12[ab]"

        System.out.println(decode(codedMsg));
    }
}
