package com.company;

public class Lesson1<x> {

    byte b = 5;
    short s = 123;
    int i = 10;
    long l = 542L;
    float f = 10f;
    double d = 10.4;
    char c = 'A';
    String str = "str";
    boolean bool = true;

    public static void main(String[] args) {
        System.out.println(doAnything(1, 2, 3, 4));
        System.out.println(moreOrLess(10, 10));
        posOrneg(0);
        System.out.println(ifNegative(-10));
        nameView("КУКУШКА");
        years(800);
    }

    public static int doAnything(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean moreOrLess(int one, int two) {
        if (10 <= (one + two) && (one + two) <= 20) {
            return true;
        } else {
            return false;
        }


    }

    public static int posOrneg(int x) {

        if (x >= 0) {
            System.out.println("POS");
        } else {
            System.out.println("NEG");
        }

        return x;
    }

    public static boolean ifNegative(int x) {

        if (x >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String nameView(String name) {
        System.out.println("Привет, " + name);
        return name;
    }

    public static int years(int year) {
        if (year % 4 == 0 && year % 100 != 0  || year % 400 == 0 )  {
            System.out.println("Високосный");
        } else {
            System.out.println(" Не Високосный");
        }

        return year;
    }
}
