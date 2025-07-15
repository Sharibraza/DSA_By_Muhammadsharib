package Queue;

import java.util.*;

public class genNBinNumbers {
     public static void genPrintBinNumbers(int n){
            Queue<String> q = new LinkedList<String>();
            q.add("1");

            System.out.print("N = " + n + " :- ");
            while (n-- > 0) {
                  String s1 = q.peek();
                  q.remove();
                  System.out.print( s1 + " ");
                  q.add(s1 + "0");
                  q.add(s1 + "1");
            }
      }
      public static void main(String[] args) {
           int n = 5; 

           genPrintBinNumbers(n);
      }
}
