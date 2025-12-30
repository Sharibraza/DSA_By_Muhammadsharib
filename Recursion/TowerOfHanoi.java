package Recursion;

public class TowerOfHanoi {

    public static void moveDisks(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        // transfer ( n - 1 ) disks from src to helper using dest as 'helper'.
        moveDisks(n - 1, src, dest, helper);

        // transfer last (nth) disk from src to dest.
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest );

        // transfer ( n - 1 ) disks from helper to dest using src as 'helper'.
        moveDisks(n-1, helper, src, dest);  
    } 

    public static void main(String[] args) {
        int n = 2;
        moveDisks(n, "A", "B", "C");
    }
}
