package PA_303_7_1;

public class Task6 {
    public static void main(String[] args) {

        // 01234
        // 02468

        int[] myNumbers = new int[5];

        for (int i = 0; i < myNumbers.length; i++) {
            myNumbers[i] = i * 2;
        }


        System.out.print("Array: ");
        for (int i = 0; i < myNumbers.length; i++) {
            System.out.print(myNumbers[i]);
            if (i < myNumbers.length - 1) {
            }
        }


    }
}
