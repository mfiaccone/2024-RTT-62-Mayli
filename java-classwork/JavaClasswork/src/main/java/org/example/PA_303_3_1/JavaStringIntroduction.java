package org.example.PA_303_3_1;

import java.util.Scanner;

public class JavaStringIntroduction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String a =sc.next();
        String b =sc.next();

        int length = a.length() + b.length();
        System.out.println(length);

        "a".compareTo("b");

        String Capitala = a.substring(0,1).toUpperCase() + a.substring(1);
        String Capitalb = b.substring(0,1).toUpperCase() + b.substring(1);
        System.out.println("Capitalized strings: " + Capitala + " " + Capitalb);
        /* Enter your code here. Print output to STDOUT. */

    }

}
