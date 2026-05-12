package DynamicProgramming;

public class ClimbingStairs {

    public static int countWays1(int n){   // O( 2^n )
        if ( n == 0) return 1;
        if ( n < 0 ) return 0;  // 1-2 = -1 -> no way for -1 so 0
        
        return countWays1(n-1) + countWays1(n-2) ;
    }

    public static int countWays2(int n, int ways[]){   // O(n)
        if ( n == 0) return 1;
        if ( n < 0 ) return 0; 

        if ( ways[n] != 0) {  // already cal?
            ways[n] = countWays2(n-1,ways) + countWays2(n-2,ways);
        }
        
        return ways[n] = countWays2(n-1,ways) + countWays2(n-2,ways) + countWays2(n-3,ways) ;
    }

    public static int countWays3(int n){   // O(n)
        int dp[] = new int[n+1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if ( i == 1) {
                dp[i] = dp[i-1] + 0 ;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays1(n));  // By Recursion

        int ways[] = new int[n+1];
        System.out.println(countWays2(4,ways));  // By Memoization  for 1.2.3 jumps

        System.out.println(countWays3(n));  // By Tabulation

    }
}
