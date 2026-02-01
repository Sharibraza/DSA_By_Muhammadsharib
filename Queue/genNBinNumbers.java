package Queue;

import java.util.*;

public class genNBinNumbers {
     public static void genPrintBinNumbers(int n){  
      
           // 1.Generates binary strings in increasing “binary order” using a queue (BFS-style generation)
           //   TC : O(N) [O(total characters printed)]   SC : O(N)
           
            Queue<String> q = new LinkedList<>();
            q.add("1");

            System.out.print("N = " + n + " :- ");
            while (n-- > 0) {
                  String s1 = q.peek();
                  q.remove();
                  System.out.print( s1 + " ");
                  q.add(s1 + "0");
                  q.add(s1 + "1");
            }

            // 2. Converts each i to binary   TC :  O(n log n)  SC :  O(log n)-[Integer.toBinaryString(i) creates a String whose length is O(log i)]

            // for (int i = 1; i <= n; i++) {
            //       System.out.print(Integer.toBinaryString(i) + " ");
            // }
            
      }
      public static void main(String[] args) {
           int n = 5; 

           genPrintBinNumbers(n);
      }
}
