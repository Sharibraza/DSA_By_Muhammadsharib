package Queue;

import java.util.*;

public class Interleave_TwoHalves_Queue {

    public static void interleave(Queue<Integer> q) {
        int size = q.size();

        Queue<Integer> first = new LinkedList<>();

        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }

        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }

    }

    public static void print(Queue<Integer> q) {
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        System.out.println("Before :- ");
        print(q);

        interleave(q);

        System.out.println("\nAfter :- ");
        print(q);

    }
}
