package com.company;

public class Lesson2 {


    public static void main(String args[]) {

        int zeroAndOne[] = new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 0};
        int plus[] = new int[8];
        int multyOnThree[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int diagOne[][] = new int[4][4];
        int minAndMax[] = new int[]{347, 10, 5, 2, 10, 9, 3700, 12, 135};
        int balance[] = new int[]{3, 4, 3, 9};
        int[] shift = new int[]{1, 1, 1, 1};


        switchZeroAndOne(zeroAndOne);
        plus3(plus);
        multiply(multyOnThree);
        printDiag(diagOne);
        minMax(minAndMax);
        checkBalance(balance);
        shiftArray(shift, -3);
    }

    //1
    public static void switchZeroAndOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    //2
    public static void plus3(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = x;
            x += 3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    //3
    public static void multiply(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    // 4
    public static void printDiag(int[][] arr) {
        for (int i = 0, y = 3, z = 0; i < arr.length; i++, y--, z++) {
            arr[i][y] = 1;
            arr[i][z] = 1;
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //5
    public static void minMax(int[] arr) {
        for (int first = 0; first < arr.length; first++) {
            int less = 0;
            int more = 0;
            for (int second = 0; second < arr.length; second++) {
                if (arr[first] > arr[second] && arr[first] != arr[second]) {
                    more++;
                    if (more == (arr.length - 1)) {
                        System.out.println("BIG " + arr[first]);
                    }
                }
                if (arr[first] < arr[second] && arr[first] != arr[second]) {
                    less++;
                    if (less == (arr.length) - 1) {
                        System.out.println("SMALL " + arr[first]);
                    }
                }
            }
        }
    }

    //6
    public static boolean checkBalance(int[] arr) {
        double sum = 0;
        double sum2 = 0;
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        for (int j = 0; j < arr.length; j++) {
            sum2 = sum2 + arr[j];
            if (sum2 == (sum / 2)) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        System.out.println();
        System.out.println(check);
        System.out.println();
        return check;
    }

    //7
    public static void shiftArray(int[] arr, int n) {
        try {
            if (n > 0) {
                for (int i = 0; i != n; i++) {
                    arr[i] = 0;
                }
                for (int i : arr) {
                    System.out.print(i);
                }
            }

            if (n < 0) {
                for (int i = (arr.length - 1), j = 0; j != n; i--, j--) {
                    arr[i] = 0;
                }
                for (int i : arr) {
                    System.out.print(i);
                }
            }
            if (n == 0) {
                for (int i : arr) {
                    System.out.print(i);
                }
            }
        }catch (ArrayIndexOutOfBoundsException m){
            System.out.println("n не может быть больше " + (arr.length) + " или меньше " + (-arr.length));
        }
     }
}
