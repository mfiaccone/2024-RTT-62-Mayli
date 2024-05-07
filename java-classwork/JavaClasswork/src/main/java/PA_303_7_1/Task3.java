package PA_303_7_1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        String[] colors = new String[]{"red" , "green" , "blue" , "yellow"};

        System.out.println(colors.length);

        //clone
        String[] newColors = colors.clone();
        System.out.println(Arrays.toString(newColors));


    }

}
