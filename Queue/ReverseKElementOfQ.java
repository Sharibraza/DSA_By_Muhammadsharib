package Queue;

import java.util.*;

public class ReverseKElementOfQ {
     public static void reverseKelements(Deque<Integer> dq, int k) {
            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < k; i++) {
                  s.push(dq.removeFirst());
            }
      
            while (!s.isEmpty()) {
                  dq.addLast(s.pop());
            }

            for (int i = 0; i < k; i++) {
                  dq.addLast(dq.removeFirst());
            }
      }
      public static void main(String[] args) {
            Deque<Integer> dq = new LinkedList<Integer>();
            int k = 5;
            dq.addLast(10);
            dq.addLast(20);
            dq.addLast(30);
            dq.addLast(40);
            dq.addLast(50);
            dq.addLast(60);
            dq.addLast(70);
            dq.addLast(80);
            dq.addLast(90);
            dq.addLast(100);

            System.out.println("Before :- " + dq);

            reverseKelements(dq,k);

            System.out.println("After :- " + dq);
      }
}
