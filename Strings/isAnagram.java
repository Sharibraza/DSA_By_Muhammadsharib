package Strings;

import java.util.Arrays;

public class isAnagram {

    public static void isAnagram(String s1, String s2) {
        String str1 = s1.toLowerCase();
        String str2 = s2.toLowerCase();

        if ( str1.length() == str2.length()) {
            
            char str1CharArr[] = str1.toCharArray();
            char str2CharArr[] = str2.toCharArray();

            Arrays.sort(str1CharArr);
            Arrays.sort(str2CharArr);
           
            Boolean res = Arrays.equals(str1CharArr,str2CharArr);
            System.out.println(res);
            if (res) {
                System.out.println(str1 + " & " + str2 + " are anagram of each others");
            }else{
                System.out.println(str1 + " & " + str2 + " are not anagram of each others");
            }
        }else{
            System.out.println(str1 + " & " + str2 + " are not anagram of each others");
        }
    }

    public static void main(String[] args) {
        String s1 = "care";
        String s2 = "rce";

        isAnagram(s1, s2);
    }
}
