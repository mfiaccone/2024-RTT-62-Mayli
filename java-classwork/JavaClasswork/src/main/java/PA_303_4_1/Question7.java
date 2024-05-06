package PA_303_4_1;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {

        System.out.println("What is your filing status? (Single: 1, Married Filing Jointly: 2, Married Filing Separately: 3, and Head of Household: 4");

        Scanner scan = new Scanner (System.in);
        String statusSelection = scan.nextLine();

        System.out.println("What is your income? ");

        Double incomeSelection = scan.nextDouble();
        if(incomeSelection < 0 ) {
            System.out.println("negative number.");
        }

        double taxTotal = 0;
        double taxRate = 0;

        //if Single section
        if (statusSelection.equalsIgnoreCase("single") || statusSelection.equals("1")) {
            System.out.print("Single Status -> ");
            if(incomeSelection <= 8350) {
                taxRate = .10;
            } else if (incomeSelection <= 33950) {
                taxRate = .15;
            } else if (incomeSelection <= 82250) {
                taxRate = .25;
            } else if (incomeSelection <= 171550) {
                taxRate = .28;
            } else if (incomeSelection <= 372950) {
                taxRate = .33;
            } else if (incomeSelection >= 372951) {
                taxRate = .35;
            }
        }

        // if married filing seperately section
        else if (statusSelection.equalsIgnoreCase("Married Filing Jointly") || statusSelection.equals("2")) {
            System.out.print("Married Filing Jointly -> ");
            if(incomeSelection <= 8350) {
                taxRate = .10;
            } else if (incomeSelection <= 33950) {
                taxRate = .15;
            } else if (incomeSelection <= 68525) {
                taxRate = .25;
            } else if (incomeSelection <= 104425) {
                taxRate = .28;
            } else if (incomeSelection <= 1086475) {
                taxRate = .33;
            } else if (incomeSelection >= 186476) {
                taxRate = .35;
            }
        }

    }
}
