package Hashing;

import java.util.HashMap;

public class LargestSubArrWithSum0 {
    
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10,23};

        HashMap<Integer, Integer> map = new HashMap<>();
        // Sum, idx(i)

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j]; // 15 , 15,-2, 15,-2,2
            if (map.containsKey(sum)) {
                len = Math.max(len, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println("Largest Subarr with Sum 0 = " + len);
    }
}
