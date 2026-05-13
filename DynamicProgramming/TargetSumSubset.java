package DynamicProgramming;

public class TargetSumSubset {

    // DP - Tabulation - O( n * sum )
    public static boolean isTargetSumSubset(int nums[], int sum) {
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // i = items, j = target sum
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true; // sum == 0
        }
        // i = 0 -> all cols of 1st row -> false ( no need to write seprately bcz java initialize bool arr with false )

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = nums[i - 1];
                //include

                if (v <= j && dp[i - 1][j-v] == true) {
                    dp[i][j] = true;
                }//exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        printDP(dp);
        return dp[n][sum];
    }

    public static void printDP(boolean  dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                 System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 7, 1, 3};
        int target = 10;

        System.out.println("\nTarget Sum exists ? : " + isTargetSumSubset(nums, target));
    }
}
