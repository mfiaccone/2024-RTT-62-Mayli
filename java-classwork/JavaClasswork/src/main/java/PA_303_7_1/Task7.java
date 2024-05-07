package PA_303_7_1;

public class Task7 {
    public static void main(String[] args) {

        String[] colors = new String[]{"blue", "red", "green", "yellow", "pink"};

        for (int i = 0; i < colors.length; i++) {
            if (i != 2) { // middle element
                System.out.println("The best colors: " + colors[i]);
            }
        }
    }

}
