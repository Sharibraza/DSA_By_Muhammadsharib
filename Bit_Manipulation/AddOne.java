// Add 1 to an integer using Bit Manipulation. (Hint : try using Bitwise NOT Operator)
// -> 
// The expression -~x will add 1 to an integer x. We know that to get negative of
// a number, invert its bits and add 1 to it (Remember negative numbers are stored in 2’s
// complement form), i.e., -x = ~x + 1; -~x = x + 1 (by replacing x by ~x)

// public class Solution {
//             public static void main(String[] args) {
//                 int x = 6;
//                 System.out.println(x + " + " + 1 + " is " + -~x);
//                 x = -4;
//                 System.out.println(x + " + " + 1 + " is " + -~x);
//                 x = 0;
//                 System.out.println(x + " + " + 1 + " is " + -~x);
//             }
//     }

package Bit_Manipulation;

import java.util.Scanner;

public class AddOne {

    public static void increment(int x) {
        int res = x | 1;
        System.out.println("Result = " + res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any numbers : ");
        int x = sc.nextInt();
        increment(x);
        sc.close();

    }
}
