package org.example;

public class Homework303_2_1 {

    public static void main(String[] args){
        // Write a program that declares two integer variables, assigns an integer to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        int num1 = 10;
        int num2 =20;

        int sum = num1 + num2;
         System.out.println("The sum of " + sum);


        //Write a program that declares two double variables, assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.

        double d1 = 20.5;
        double d2 = 20.5;

        double dSum = d1 + d2;
        System.out.println(dSum);


        //Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together.
        // Assign the sum to a variable. Print out the result. What variable type must the sum be?
        int c = 30;
        double b = 50.55;

        double sum3 = c + b;
        System.out.println(sum3);

        //variable type has to be double

        //Write a program that declares two integer variables, assigns an integer to each, and divides the larger number by the smaller number.
        // Assign the result to a variable. Print out the result.
        // Now change the larger number to a decimal. What happens? What corrections are needed?

        double v1 = 80.7;
        int v2 = 50;

        double div = (double)v1 / (double)v2;
        System.out.println(div);

        // When I changed the larger number to a decimal, I had to change the first integer to a double for it to print


        // Write a program that declares two double variables, assigns a number to each, and divides the larger by the smaller number.
        // Assign the result to a variable. Print out the result. Now, cast the result to an integer.
        // Print out the result again.

        double v3 = 17.7;
        double v4 = 18.8;

        double divide = (v4 / v3);
        System.out.println(divide);

        int result = (int)divide;
        System.out.println(result);

        // Write a program that declares two integer variables, x and y, and assigns the number 5 to x and the number 6 to y.
        // Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign it to q.
        // Print q again.

        int x = 5;
        int y = 6;

        int q = y / x;
        System.out.println(q);

        q = (int)((double)y);
        System.out.println(q);

        // not to sure about this last part for this one



    }

}
