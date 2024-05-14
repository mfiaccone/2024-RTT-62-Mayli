package Slides_303_11;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class IndExercise1 {
    public static void main(String[] args) {

        Map<String, Integer> stringMap = new HashMap<>();

        stringMap.put("First", 10);
        stringMap.put("Second", 20);

        for (String key : stringMap.keySet()) {

            System.out.println("HashMap: " + stringMap);
        }

        //this is how the example is but intellij won't recognize variable x
        //for (Map.Entry x : stringMap.entrySet());
        //System.out.println(x.getKey() + " " + x.getValue());
    }




}
