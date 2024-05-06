package Slides303_4;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        // This program first prompts the use to enter a year as an int, and checks if it is a leap year
        // A year is a  leap year if it is divisible by 4 but not by 100, or it is divisible by 400.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = scanner.nextInt();

        boolean isLeapYear = false;
        if((year % 4 == 0) && (year % 100 > 0)) {
            isLeapYear = true;

        } else if ( year % 400 == 0 ) {
            isLeapYear = true;

        }

        System.out.println(year + " is a leap year" + isLeapYear);

    }


}
