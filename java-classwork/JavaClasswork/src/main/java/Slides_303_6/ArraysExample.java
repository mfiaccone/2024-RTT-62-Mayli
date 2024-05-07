package Slides_303_6;

public class ArraysExample {

    public static void main(String[] args) {

        //can create variable and new array in the line line too
        double[] dArray = new double[10];

        //this is also a valid way of creating a new array not that
        //it is on 2 lines. First create the variable, 2nd creates the new array in memory
        int[] iArray;
        iArray = new int[20];

        //this gets used a bit from time to time
        // the compiler will see this and create  an array of strings with size of 3 and puts the 3 values in the array
        String[] constants = {"String1", "String2", "String3"};
        for (String constant : constants) {
            System.out.println(constant);
        }

        //this also works for other data types
        int[] intConstant = {1, 2, 3, 4, 5,};


    }
}


















