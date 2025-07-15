package Queue;

import java.util.*;

public class Reverse_Queue {
    
      public static void print(Queue<Integer> q) {
            while (!q.isEmpty()) {
                  System.out.print(q.peek() + " ");
                  q.remove();
            }
      }

      public static void reverse(Queue<Integer> q) {
            Stack<Integer> s = new Stack<>();

            while (!q.isEmpty()) {
                  s.add(q.remove());
            }

            while (!s.isEmpty()) {
                  q.add(s.pop());
            }
      }

      public static void main(String[] args) {
            Queue<Integer> q = new LinkedList<>();

            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            q.add(5);

            reverse(q);
            System.out.println("Reversed Queue :- ");
            print(q);

      }
}
