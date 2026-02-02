package Arrays.Array_1D;

public class MajorityElement {

    // *** Boyer-Moore Voting Algorithm 
    
     public static int majorityElement(int[] nums) {
           int n = nums.length;  // Length of the array
           int majority= -1;         // Initialize result as -1 (default if no majority)


           // Loop through each element to check its frequency
           for (int i = 0; i < n; i++) {
               int count = 1;  // Count starts at 1 (include current element)


               // Count occurrences of nums[i] in the rest of the array
               for (int j = i + 1; j < n; j++) {
                   if (nums[j] == nums[i]) {
                       count++;
                   }
               }


               // If count exceeds n/2, it's a majority element
               if (count > n / 2) {
                   majority = nums[i];
               }
           }


           // Return the result (either the majority element or -1)
           return majority;
       }

   public static void main(String[] args) {
       int[] nums = {2, 2, 1, 1, 2, 2, 2};


       System.out.println(majorityElement(nums));
   }
}
