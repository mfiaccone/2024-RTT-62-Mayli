package org.example;

public class SBA1Practice {

    public static void main(String[] args) {




        String s  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //part 1 - create a for loop to print each character of the string s on its own line
        //you can use the s.charAt(pos) function

        for(int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));

        }



        /* output:
        A
        B
        C
        D
        E
        F
        ...
         */

        //part2
        //given the following Strings convert them to integer values Integer.valueOf() - can use Integer.parseInt() too
        String ten = "10";
        String hundred = "100";

        int ten1 = Integer.valueOf(ten);
        int hund = Integer.valueOf(hundred);

        System.out.println(ten1);
        System.out.println(hund);

        System.out.println("As an integer: " + Integer.valueOf(ten));
        System.out.println("Another integer: " + Integer.valueOf(hundred));




        //part 3
        //given an integer array find the sum of all the integers in the array
        int[] array = {2, 4, 5, 6, 7, 8, 10};
        int sum = 0;

        for(int a = 0; a < array.length; a++) {
            sum = sum + array[a];
        }

        System.out.println("Sum: " + sum);




        //part 4
        //given the array of string convert them to numbers and print the sum
        String[] nums = {"2", "4", "5", "6", "7", "8", "10" };
        int add = 0;

        for(String num : nums){
            int value = Integer.valueOf(num);
            add = add + value;

            System.out.println(Integer.parseInt(num));
        }
    }
}


