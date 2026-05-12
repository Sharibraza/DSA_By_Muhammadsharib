package DynamicProgramming;

public class DP_Fibonnaci {

    // 1. Memoization
    public static int fibo1(int n, int[] f) { // O(n)

        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) {
            return f[n] = fibo1(n - 1, f) + fibo1(n - 2, f);
        }

        return f[n] = fibo1(n - 1, f) + fibo1(n - 2, f);
    }

    // 2. Tabulation
    public static int fibo2(int n) {    // O(n)

        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n]; 
    }

    public static void main(String[] args) {
        int n = 5;

        // memoization
        int f[] = new int[n + 1]; // 0,0,0....

        System.out.println(fibo1(n, f));
        // System.out.println(fibo2(n));
    }
}
