package PA_303_4_1;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        int userInput = scan.nextInt();

        System.out.print("Today is ");
        switch(userInput) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Out of range");
                break;
        }
        scan.nextLine();
    }
}
