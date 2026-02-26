package Hashing;

import java.util.HashSet;


public class HashSet_Implementation{

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(4);
         hs.add(3);
        hs.add(1);
        hs.add(2);

        System.out.println(hs.size());  // No duplicates
        System.out.println(hs);


    }
}