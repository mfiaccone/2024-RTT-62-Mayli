package org.example;

public class StringBufferExample {
    //KBA question!

    public static void main(String[] args) {
        //0123456789012345
        //filename.txt

        //NOTE: the 2nd argument is not inclusive of the position
        //NOTE: run this in the debugger to see what each statement is doing
        //NOTE: for KBA use a piece of blank scratch paper to write the string down after each operation

        StringBuffer sb = new StringBuffer("filename.txt");

        sb.insert(0,"new_");

        //0123456789012345
        //filename.txt
        System.out.println(sb);

        sb.replace(0,4,"old_");

        //0123456789012345
        //old_filename.txt
        System.out.println(sb);

        //the thing to memorize for the KBA is that: replace is going first delete the items from
        // 0 to 4 then insert the string at position starting
        sb.replace(0,4,"very_old_");

        //0123456789012345
        //very_old_filename.txt
        System.out.println(sb);

        sb.reverse();

        //0123456789012345
        //very_old_filename.txt
        System.out.println(sb);



    }
}
