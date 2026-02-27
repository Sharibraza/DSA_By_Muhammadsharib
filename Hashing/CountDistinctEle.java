package Hashing;

import java.util.HashSet;

public class CountDistinctEle {
    
    public static void main(String[] args) {
        
        int nums[] = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();

        for (Integer ele : nums) {
            set.add(ele);   
        }

        System.out.println("Count of Distinct Element = " + set.size());
    }
}
