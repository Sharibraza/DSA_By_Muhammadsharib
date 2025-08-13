package Backtracking;

public class Subsets {
    public static void subSets(String str, String ans, int i) {
        
        if ( i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("''");
            }else{
                System.out.println(ans);
            }
            return;
        }
        
        subSets(str,  ans + str.charAt(i), i+1);
        subSets(str,  ans, i+1);
    }


    public static void main(String[] args) {

        String str = "abc";

        subSets(str, "",0);
        
    }
}
