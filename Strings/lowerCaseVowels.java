package Strings;

import java.util.Scanner;

public class lowerCaseVowels {
    
    public static int isLowerCase(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      Character ch = str.charAt(i);
      if ( Character.isLowerCase(ch) && ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter any Text : ");
    String str = sc.next();

    System.out.println(isLowerCase(str));
  }
}
