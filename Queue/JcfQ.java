package Queue;

import java.util.*;

public class JcfQ {
    
    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.print(" | ");
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " | ");
            q.remove();
        }

    }
}
