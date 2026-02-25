package Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMap_Code {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();  // maintain order of insertion
        lhm.put("india", 100);
        lhm.put("us", 90);
        lhm.put("uk", 80);
        lhm.put("china", 60);

        System.out.println("Order Maintained : " + lhm);


        HashMap<String, Integer> hm = new HashMap<>();  // Random order

        hm.put("india", 100);
        hm.put("us", 90);
        hm.put("uk", 80);
        hm.put("china", 60);

        System.out.println("Order Maintained : " + hm);

    }
}
