package Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKsortedLL {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void addLLtoPq( LinkedList<Integer> l){
        
        while( !l.isEmpty()){
            pq.add(l.poll());
        }
    }
    
    public static void main(String[] args) {
        int K=3, N=3 ;

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(3);
        l1.add(7);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(4);
        l2.add(8);
        LinkedList<Integer> l3 = new LinkedList<>();
        l3.add(9);
        l3.add(10);
        l3.add(11);

        addLLtoPq(l1);
        addLLtoPq(l2);
        addLLtoPq(l3);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + "->");
        }
        System.out.print("null");
    }
}
