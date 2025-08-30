package Backtracking;

public class Grid_Ways {

    // public static int GridWays(int i, int j, int n, int m) { // O(2^n+m)

    // if ( i == n-1 && j == m-1) {
    // return 1;
    // }else if ( i == n || j == m ){
    // return 0;
    // }

    // int w1 = GridWays(i+1,j,n,m);
    // int w2 = GridWays(i,j+1,n,m);

    // return w1 + w2 ;
    // }

    public static int factorial(int num) {

        if (num == 0 || num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }

    public static int GridWays(int i, int j, int n, int m) { // O(n + m)

        int totalWays = factorial((n - 1 + m - 1)) /
                (factorial(n - 1) * factorial(m - 1));

        return totalWays;
    }

    public static void main(String[] args) {

        int n = 3, m = 3;

        System.out.println(GridWays(0, 0, n, m));

    }
}
