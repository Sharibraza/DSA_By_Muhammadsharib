// Swap two numbers without using any third variable.
// -> The idea is to use XOR operators to swap two numbers by their property x ^ x = 0

package Bit_Manipulation;

import java.util.Scanner;

public class Swap {

     public static void swap(int a, int b){
        System.out.println("Before swapping :\na = " + a + "\nb =  " + b);
        a = a ^ b ;
        b = a ^ b ;
        a = a ^ b ;
        System.out.println("After swapping :\na = " + a + "\nb =  " + b);
     }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any Two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        swap(a,b);
        sc.close();
     }
}