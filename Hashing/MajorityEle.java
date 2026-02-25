package Hashing;

import java.util.*;

public class MajorityEle {

    public static void majorityElement(int[] nums) {

        List<Integer> majorityElements = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for ( int i = 0 ; i < n ; i++){
            int num = nums[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num : map.keySet()) {
            if ( map.get(num) > n/3 ){
                majorityElements.add(num);
            }
        }

        System.out.println("Majority ele = " + majorityElements);
    }
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};
        int nums2[] = {1,2};

        majorityElement(nums2);
    }
}
