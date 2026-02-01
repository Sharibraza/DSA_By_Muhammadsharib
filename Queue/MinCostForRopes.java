package Queue;

import java.util.PriorityQueue;

public class MinCostForRopes {
     public static void minCost(int n, int len[]) {     // TC : o(n)  SC : o(n)
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < len.length; i++) {
                  pq.add(len[i]);
            }
            int result = 0 ;

            while (pq.size() > 1) {
                int first = pq.poll();  // retrieves and removes the “front” element, but doesn’t throw an exception if the queue is empty.
                int second = pq.poll();
                result += first + second ;
                pq.add(first + second );
            }

            System.out.println("The Total Cost for connecting " + n + " ropes = " + result);
      }

      public static void main(String[] args) {
            int len[] = { 4, 3, 2, 6 };
            int n = 4;
            minCost(n, len);
      }
}
