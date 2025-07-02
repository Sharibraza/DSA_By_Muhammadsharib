package Recursion;

public class LengthOfStr {

    // public static void findLength(String str, int i, int len) {
    // char newStr[] = str.toCharArray();

    // if (i == newStr.length || str.length() == 0) {                   ---- BruteForce
    // System.out.println(len);
    // return;
    // }
    // len++;
    // findLength(str, i + 1, len);
    // }

    public static int findLength(String str) {
        
        if ( str.length() == 0) {
            return 0;
        }

        return findLength(str.substring(1)) + 1 ;
    }

    public static void main(String[] args) {
        String str = "abcde";
        // int len = 0;

        // findLength(str,0,len); ----BruteForce
          int length = findLength(str);      // ---- use no. of calls in stack
          System.out.println(length);
    }
}
