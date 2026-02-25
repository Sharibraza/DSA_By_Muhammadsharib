package Hashing;

import java.util.TreeMap;

public class TreeMap_Code {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();  // Keys are in sorted order
        tm.put("India", 100);
        tm.put("US", 90);
        tm.put("uk", 80);
        tm.put("China", 150);
        tm.put("Indo", 6);
        tm.put("Pak", 2);



        System.out.println("Sorted order {based on keys} : " + tm);

    }
}
