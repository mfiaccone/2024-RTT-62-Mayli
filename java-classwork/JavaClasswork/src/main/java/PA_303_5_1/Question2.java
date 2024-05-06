package PA_303_5_1;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter a positive integer: ");
        int n1 = scanner.nextInt();

        System.out.println("Enter a second positive integer: ");
        int n2 = scanner.nextInt();

        int smll = Math.min(n1, n2);
        int lrg = Math.max(n1, n2);
        if (lrg % smll == 0) {
            System.out.println("GCD is " + smll);
            return;
        }

        while (lrg % smll != 0) {
            int remainder = lrg % smll;
            lrg = smll;
            smll = remainder;
        }
        System.out.println("GCD is " + smll);
    }


    }

