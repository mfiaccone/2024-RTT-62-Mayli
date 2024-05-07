package PA_303_7_1;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        int[] myNumbers = new int[5];

        for (int i = 0; i < myNumbers.length; i++) {
            myNumbers[i] = i;
        }

        System.out.print("Array: ");

        for (int i = 0; i < myNumbers.length; i++) {
            System.out.print(myNumbers[i]);
            if (i < myNumbers.length - 1) {
            }
        }


    }
}
