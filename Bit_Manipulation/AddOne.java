package Bit_Manipulation;

import java.util.Scanner;

public class AddOne {
    
    public static void increment( int x){
        int res = x | 1 ;
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
