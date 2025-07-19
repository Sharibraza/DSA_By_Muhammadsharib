package Basic_Math;

public class DecToBin {

    public static void d_bin(int decN) {
       
        int binN = 0 ;
        int pow = 0;

        while (decN > 0) {
            int rem = decN % 2;
            binN = binN + (rem * (int)Math.pow(10,pow));
            pow++;

            decN = decN / 2;
        }

        System.out.println(binN);
    }

    public static void main(String[] args) {
        int n = 5 ;
        d_bin(n);
    }
}
