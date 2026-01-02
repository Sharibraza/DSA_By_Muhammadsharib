package Divide_Conquer;

public class MajorityEle {

    // public static int majorityElement(int nums[]) {

        // My 1st Bruteforce    Time complexity - O(n^2)

        // int ele=0;
        // int prevCount = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int currCount=1;
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             currCount++;
        //             if ( currCount > (nums.length / 2) || currCount > prevCount ) {
        //                 prevCount = currCount;
        //                 ele=nums[i];
        //             }

        //         }
        //     }
        // }
        // return ele ;

        // 1. sol Bruteforce   Time complexity - O(n^2)

        // int majorityCount = nums.length / 2;
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             count += 1;
        //         }
        //     }
        //     if (count > majorityCount) {
        //         return nums[i];
        //     }
        // }
        // return -1;
    // }

    // 2. Divide and Conquer

    public static int countInRange(int nums[], int num, int lo, int hi){
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
               count++; 
            }
        }
        return count;
    }
    public static int majorityElementRec(int nums[], int lo, int hi){
        // base case; the only element in an array of size 1 is the majority element.
        if (lo == hi) return nums[lo];

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;

        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if ( left == right) return left;

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right ;
    }

    public static int majorityElement(int nums[]){
        return majorityElementRec(nums,0, nums.length-1);
    }

    public static void main(String[] args) {

        int nums[] = {3,2,3};
        // assume that the majority element always exists in the array.

        System.out.println("Majority Ele = " + majorityElement(nums));

    }
}
