package DynamicProgramming;

public class Unbounded_Knapsack {

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) { // 0th col
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp.length; i++) { // 0th row
            dp[0][i] = 0;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int v = val[i -1]; // ith item val
                int w = wt[i-1];  // ith item wt

                if ( wt[i-1] <= j) { // valid
                    dp[i][j] = Math.max( val[i -1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else{ // invalid
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }

        printDP(dp);

        return dp[n][W]; 
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println("Max Profit = " + knapsack(val, wt, W));
    }

}
