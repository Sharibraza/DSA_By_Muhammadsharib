package DynamicProgramming;

public class RodCutting {

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int rodCutting(int[] prices, int[] len, int totRod) {
        int n = prices.length;
        int dp[][] = new int[n + 1][totRod + 1];

        for (int i = 0; i < n+1; i++) { // 0th col
            for (int j = 0; j < totRod+1; j++) {
                if( i == 0 || j == 0) {
                    dp[0][i] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                if (len[i - 1] <= j) { // valid
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDP(dp);

        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int prices[] = {1,5,8,9,10,17,17,20};
        int length[] = {1,2,3,4,5,6,7,8};
        int rodLength = 8;

        System.out.println("Max Profit = " + rodCutting(prices, length, rodLength));
    }
}
