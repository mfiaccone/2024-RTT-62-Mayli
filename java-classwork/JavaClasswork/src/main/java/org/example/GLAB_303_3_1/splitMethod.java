package org.example.GLAB_303_3_1;

import java.util.Arrays;

public class splitMethod {
    public static void main(String[] args) {

        // importing Arrays to convert array to string
        // used for printing arrays


        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));

    }
}