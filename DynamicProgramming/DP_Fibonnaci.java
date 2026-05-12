package DynamicProgramming;

public class DP_Fibonnaci {

    public static int fibo(int n, int[] f) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) {
            f[n] = fibo(n - 1, f) + fibo(n - 2, f);
        }

        return f[n] = fibo(n - 1, f) + fibo(n - 2, f);
    }

    public static void main(String[] args) {
        int n = 6;

        // memoization
        int f[] = new int[n + 1]; // 0,0,0....
        System.out.println(fibo(n, f));
    }
}
