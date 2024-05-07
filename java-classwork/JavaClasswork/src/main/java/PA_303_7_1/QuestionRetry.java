package PA_303_7_1;

import java.util.Arrays;

public class QuestionRetry {

    public static void main(String[] args) {
        int[] array = new int[10];
        int sum = 0;
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            sum += array[i];
            if (array[i] < small) {
                small = array[i];
            }
            if (array[i] > large) {
                large = array[i];
            }
        }

        System.out.println("Smallest integer in the array: " + small);

        System.out.println("Largest integer in the array: " + large);


    }


    }