package PA_303_7_1;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {

        String[] colors = new String[]{"blue", "red", "green", "yellow", "pink"};

        int middle = colors.length / 2;

        String temp = colors[0];
        colors[0] = colors[middle];
        colors[middle] = temp;


        System.out.println("Swapped: " + Arrays.toString(colors));
    }

}
