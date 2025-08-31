package Greedy_Algorithm;

public class MaxBalancedSubStr {
    public static int BalancedPartition(String str, int n) {

        if (n == 0)
            return 0;

        int L = 0, R = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == 'R') {
                R++;
            } else {
                L++;
            }

            if (L == R) {
                System.out.println(str.substring(0, i));
                ans++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int n = str.length();

        System.out.println(BalancedPartition(str, n));
    }
}
