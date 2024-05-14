package Slides_303_12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsExamples {

    private Scanner scanner = new Scanner(System.in);

    public int captureInput() throws Exception {
        System.out.print("Enter an array position: ");
        int value = scanner.nextInt();
        return value;
    }


    public void run() {

        int[] array = new int[10];


        try {
            System.out.println("Before error");

            int pos = captureInput();

            pos = pos / 0; // this is going to be caught my exception e and tell us arithmetic error

            //when the exception occurs on this line it will automatically jump to the catch block (no matter how many lines of code)
            array[pos] = 5;

            // any code after the exception will not get run
            System.out.println("After Error - no error occured");

        } catch ( InputMismatchException ime) {
            System.out.println("The user entered bad data");

        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("The user entered an invalid array  positon");

        } catch (Exception e) {
            System.out.println("Caught the exception e with message: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // this code will execute no matter what
            System.out.println("Inside the finally block");

        }
    }

    public static void main(String[] args) {
        ExceptionsExamples ee = new ExceptionsExamples();
        ee.run();
    }
}
