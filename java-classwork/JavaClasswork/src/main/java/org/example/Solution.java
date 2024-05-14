package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        try {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int answer = x / y;

            System.out.println(answer);

        } catch (InputMismatchException a) {
            System.out.println(a);
        } catch (ArithmeticException b) {
            System.out.println(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

