package Basic_Math;

public class BintoDec {
      
     public static int b_dec(int binN) {
            int pow = 0;
            int dec = 0;

            while (binN > 0 ) {
                 int ld = binN % 10;
                 dec = dec +  ( ld * (int)Math.pow(2, pow));

                 pow++;
                 binN = binN / 10;
            }

            return dec;
      }
      public static void main(String[] args) {
           
            System.out.println(b_dec(1000));
      }
}
