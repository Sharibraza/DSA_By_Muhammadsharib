package DynamicProgramming;

public class CoinChange {

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printAllWays(int[] coins, int sum, int index, String currentWay) {
        if (sum == 0) {
            System.out.println(currentWay);
            return;
        }
        if (sum < 0 || index >= coins.length) {
            return;
        }

        // Include current coin
        printAllWays(coins, sum - coins[index], index, currentWay + coins[index] + " ");
        // Exclude current coin and move to next
        printAllWays(coins, sum, index + 1, currentWay);
    }

    public static int coinChange(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < dp.length; i++) { // 0th col - when i = 0
            dp[i][0] = 1;
        }

        // implicitly initialized by java 
        // for (int i = 1; i < dp.length; i++) { // 0th row - when sum = 0
        //     dp[0][1] = 0;
        // }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < sum+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printDP(dp);
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1,2,3}; // {2,5,3,6}
        int sum = 4;          // 10

        System.out.println("Total Ways = " + coinChange(coins, sum));
        System.out.println("\nAll Ways:");
        printAllWays(coins, sum, 0, "");

    }
}
