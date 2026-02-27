package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSet_Implementation {

    public static void main(String[] args) {
        // HashSet<Integer> hs = new HashSet<>();
        // hs.add(1);
        // hs.add(2);
        // hs.add(4);
        // hs.add(3);
        // hs.add(1);
        // hs.add(2);

        // System.out.println(hs.size());  // No duplicates
        // System.out.println(hs);
        // Iteration on HashSet 
        HashSet<String> hs = new HashSet<>();
        hs.add("India");
        hs.add("UAE");
        hs.add("Indo");
        hs.add("UK");

        // 1. Using Iterator()
        // Iterator itr = hs.iterator();
        // while(itr.hasNext()){
        //     System.out.print(itr.next() + " ");
        // }  // unordered -> Indo UK UAE India 

        System.out.print("HashSet : ");

        // 2. foreach
        for (String val : hs) {
            System.out.print(val + " ");
        }

        System.out.println("");
        

        // 2. LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("India");
        lhs.add("UAE");
        lhs.add("Indo");
        lhs.add("UK");

        System.out.print("LinkedHashSet : ");
        for (String val : lhs) {
            System.out.print(val + " ");
        }

        System.out.println("");

        // 3. TreeSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("India");
        ts.add("UAE");
        ts.add("Indo");
        ts.add("UK");
        ts.add("Atlantis");
        ts.add("Bhutan");

        System.out.print("TreeSet : ");
        for (String val : lhs) {
            System.out.print(val + " ");
        }
    }
}
