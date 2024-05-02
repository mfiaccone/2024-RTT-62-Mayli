package org.example.GLAB_303_3_1;

public class CompareToExample {
    public static void main(String args[]) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hemlo";
        String s4 = "flag";
        System.out.println(s1.compareTo(s2)); // 0 because both are equal
        System.out.println(s1.compareTo(s3)); //-1 because "l" is only one time lower than "m"
        System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"

        //The above program shows the comparison between the various Strings. Notice:
        //if s1 > s2, it returns a positive number.
        //if s1 < s2, it returns a negative number.
        //if s1 == s2, it returns 0.

    }
}