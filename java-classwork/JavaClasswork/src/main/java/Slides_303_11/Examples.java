package Slides_303_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Examples<T> {

    public void setSomething(T variableName) {


    }

    public T getSomething() {
        return null;
    }



    public static void main(String[] args) {

        Examples<String> e = new Examples<>();
        e.setSomething("String");

        Examples<Integer> e1 = new Examples();
        e1.setSomething(10);

        List<Object> list = new ArrayList();




        String one = "one";
        Integer ten = 10;

        list.add(one);
        list.add(one);
        list.add(ten);

        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("123");

        System.out.println("Set size = " + set.size());

        set.add("abc");



    }
}
