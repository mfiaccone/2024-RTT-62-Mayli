package Slides_303_14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachExample {
    public static void main (String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Larry");
        names.add ("Steve") ;
        names.add ("James") ;
        names.add ("Jessica");
        names.add ( "Conan") ;
        names.add ( "Ellen") ;


        names.forEach (name -> {          // these two things are doing the same thing
            System.out.println (name);
        } );

        //this is printing the names with a lamba

        System.out.println("=============================================");

        for(String name : names) {       // These two things are doing the same thing
            System.out.println(name);
        }

        //this is printing all names in the list with a new style for loop

        System.out.println("=============================================");

        //using lamba to remove items from the list
        names = names.stream().filter(name -> !name.startsWith("E")).collect(Collectors.toList());

        //print the list after the items are removed
        for(String name : names) {
            System.out.println(name);
        }

        //count the number of names in the list that start with J
        long count = names.stream().filter(name -> name.startsWith("J")).count();
        System.out.println("Names in list starting with J : " + count);

    }

}
