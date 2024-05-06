package Slides303_4;

import java.util.ArrayList;
import java.util.List;

public class ForLoopExample {

    public static void main(String[] args) {

        for ( int count = 0 ; count < 10; count++) {
            System.out.println("The count = " + count);

            for (int d = 0; d < 5; d++ ) {
                System.out.println("The count = " + count + " , " + d);

            }

            //many line of  code can be in here
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("First Element"); // position 0
        stringList.add("Two"); // position1
        stringList.add("Three"); // position 2
        stringList.add("Four"); // position 3
        stringList.add("5"); // position1 4

        //we can use an old style for loop to move across this list
        for (int pos = 0; pos < stringList.size(); pos++) {
            System.out.println(stringList.get(pos));

        }

        for (int pos = stringList.size() - 1; pos >= 0; pos--) {
            System.out.println(stringList.get(pos));
        }

        System.out.println("---------------------");

        //nice new for loop
        for (String element : stringList) {
            if (element.equals("Three")) {
                continue;

            }
            System.out.println(element);
        }

    }
}
