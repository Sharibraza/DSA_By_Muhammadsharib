package Strings;
import java.util.*;

public class CountVowel {

    public static void countVowel(String str) {
        String newStr = str.toLowerCase();
        int vowelCount =0;

        for (int i = 0; i < newStr.length(); i++) {
            char ch = newStr.charAt(i);
            if ( ch == 'a' ||  ch == 'e' ||  ch == 'i' ||  ch == 'o' ||  ch == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Vowel Count : " + vowelCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Phrase : ");
        String str = sc.nextLine();

        countVowel(str);

    }
}