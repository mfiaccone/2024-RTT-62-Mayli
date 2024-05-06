package PA_303_4_1;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);

        Double grade = scan.nextDouble();

        if(grade >= 90 & grade <= 100) {
            System.out.println("Your grade is: A");
        } else if (grade >= 80 && grade <= 89) {
            System.out.println("Your grade is: B");
        } else if (grade >= 70 && grade <= 79) {
            System.out.println("Your grade is: C");
        } else if (grade >= 60 && grade <= 69) {
            System.out.println("Your grade is: D");
        } else if (grade < 60 && grade >= 0) {
            System.out.println("Your grade is: F");
        } else {
            System.out.println("Score out of range");
        }
    }
}
