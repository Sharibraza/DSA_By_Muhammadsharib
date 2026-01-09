package Backtracking;

public class KeypadCombinations {

    final static char[][] L = {{},{},
        {'a','b','c'},{'d','e','f'},{'g','h','i'},
        {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
        {'t','u','v'},{'w','x','y','z'}};

        public static void bfs(int pos, int len, StringBuilder sb, String digits ){
            if ( pos == len ) {
                System.out.print("'" + sb.toString() + "'" + " ");
            }else{

                char letters[] = L[Character.getNumericValue(digits.charAt(pos))];

                for (int i = 0; i < letters.length; i++) {
                    bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), digits);
                }
            }
        }
        public static void keypadCombinations(String digits){
            
            int len = digits.length();
            if ( len == 0) {
                System.out.println("");
                return;
            }

            bfs(0, len, new StringBuilder() , digits);
        }
    public static void main(String[] args) {

        keypadCombinations("23");
    }
}
