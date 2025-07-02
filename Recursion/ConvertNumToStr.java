package Recursion;

public class ConvertNumToStr {

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine" };

    public static void convertNum(int nums) {

        if (nums == 0) {
            return ;
        }

        int lastDigit = nums%10;
        convertNum(nums/10);
        System.out.print("'" + digits[lastDigit] + "'" + " ");
    }

    public static void main(String[] args) {
        convertNum(2005);
    }
}
