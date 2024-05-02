package org.example;

import java.text.DecimalFormat;

public class FirstJavaClass {

    public static void main(String[] args) {
        byte num;   // This can hold whole number between -128 and 127.
        num = 113;
        System.out.println(num);

        short snum;
        snum = 150;
        System.out.println(snum);

        long lnum = -12332252626L;
        System.out.println(lnum);

        double dnum = -42937737.9d;
        System.out.println(dnum);

        float fnum = 19.98f;
        System.out.println(fnum);

        boolean b = false;
        System.out.println(b);

        char ch = 'Z';
        System.out.println(ch);


        //homework question class review for Homework 303_2_1

        double coffee = 2.50;
        double cappuccino = 3.50;
        double espresso = 4.58;

        double subtotal = (coffee *3) + (cappuccino *4) + (espresso * 2);

        final double SALES_TAX = .09;

        double salesTaxAmount = subtotal + SALES_TAX;
        double totalAmount = subtotal + salesTaxAmount;

        DecimalFormat df = new DecimalFormat ("0.00");
        System.out.println("Subtotal:" + df.format(subtotal));
        System.out.println("Subtotal:" + df.format(salesTaxAmount));
        System.out.println("Subtotal:" + df.format(totalAmount));

        //------------------------------------



    }
}

