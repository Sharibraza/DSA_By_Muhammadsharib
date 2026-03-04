package Hashing;

import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //diff = given target - number given at ith index
            int diff = target - nums[i];
            // check if found difference is present in the MAP list
            if (visited.containsKey(diff)) {
                //if difference in map matches with the ith index element in array
                return new int[]{visited.get(diff), i,};
            }
            //add arr element in map to match with future element if forms a pair
            visited.put(nums[i], i);
        }
        //if no matches are found
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 4};
        int target = 6;

        int[] ans = findTwoSum(nums, target);

        System.out.print("Addition of ");
        for (int i : ans) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("= " + target);
    }
}
