package Stack;

import java.util.Stack;

public class SimplifyPath {

    // static Stack<Character> s = new Stack<>();

    // my BruteForce -- ( has flaws )
    
    // public static void simplifyAbsPath(String path){
    //     int n = path.length();
    //     for (int i = 0; i < path.length(); i++) {
    //         char ch = path.charAt(i);
    //         s.push(ch);
    //         if ( !s.isEmpty() && ch == '.' && s.peek() == '.' && i+1 == path.length()) {
    //             while (n - 1 >= 1) {
    //                 s.pop();
    //                 n--;
    //             }
    //         }else if ( !s.isEmpty() && s.peek() == '.' && i+1 == path.length()) {
    //             while ( !s.isEmpty() &&  s.peek() == '/') {
    //                 s.pop();
    //             }
    //         }else if ( !s.isEmpty() && s.peek() == '/' && i+1 == path.length()) {
    //              while ( !s.isEmpty() && s.peek() == '/') {
    //                 s.pop();
    //             }
    //         }
    //     }
    // }


    public static String simplifyAbsPath(String path) {

        Stack< String> st = new Stack<>();
        String res = "";
        res += "/";
        int n = path.length();

        for (int i = 0; i < n; i++) {
            String dir = "";

            while (i < n && path.charAt(i) == '/') {
                i++;
            }

            while (i < n && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;
            }

            if (dir.equals("..") == true) {

                if (!st.empty()) {
                    st.pop();
                }

            } else if (dir.equals(".") == true) {
                continue;
            } else if (dir.length() != 0) {
                st.push(dir);
            }
        }

        Stack< String> st1 = new Stack<>();

        while (!st.empty()) {
            st1.push(st.pop());
        }

        while (!st1.empty()) {
            if (st1.size() != 1) {
                res += (st1.pop() + "/");
            } else {
                res += st1.pop();
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String path = "/apnacollege/";   // 1. "/a/.."  2. "/apnacollege/"

        // simplifyAbsPath(path);
        // String res = "";
        // while (!s.isEmpty()) {
        //     res += s.pop();
        // }
        // System.out.print(reverseString.revString(res));

        // -------------------------------- //
        String res = simplifyAbsPath(path);
        System.out.print(res);

    }
}
