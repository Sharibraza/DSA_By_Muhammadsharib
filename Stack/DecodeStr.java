package Stack;

import java.util.Stack;

public class DecodeStr {

    // Bruteforce : My approach
    public static StringBuilder decode(String codedMsg){
        Stack<Character> s = new Stack<>();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < codedMsg.length(); i++) {
            
            char ch = codedMsg.charAt(i);

            if ( ch == ']') {
                
                while ( s.peek() != '[' ) {
                    code.append( s.pop() );
                }
                s.pop();  // pop [

                code.reverse();
                code.repeat(code, s.pop() - '0' - 1 );  // multiplying str with num                
            }else{
                s.push(ch);
            }
        }
        return  code;
    }
    public static void main(String[] args) {
        String codedMsg = "3[b2[v]]L" ;// 1. "2[cv]"  2. "3[b2[v]]L"

       System.out.println( decode(codedMsg) );
    }
}
