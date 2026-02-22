package Hashing;

import java.util.HashMap;

public class Hashmap_Implementation {
    
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        // Put - O(1)
        hm.put("India", 100);
        hm.put("UAE", 60);
        hm.put("Indo", 40);
        hm.put("UK", 40);

        System.out.println(hm);

        // Get - O(1)
        System.out.println(hm.get("India"));

        // ContainsKey - O(1)
        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("usa"));  //false

        // remove - O(1)
        System.out.println(hm.remove("UK"));

        System.out.println(hm);

        // size 
        System.out.println(hm.size());

        // isEmpty 
        System.out.println(hm.isEmpty());

        // clear() 
        hm.clear();
 
        System.out.println(hm);
    }
}
