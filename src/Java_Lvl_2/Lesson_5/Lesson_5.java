package com.company;

public class Lesson_5{
    static final int size = 1000000;
    static final int h = size/2;

    public static void main(String[] args) {
        float arr[] = new float[size];
        oneThread(arr);
        twoThread(arr);
    }
    static void oneThread(float arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        System.out.println("Один поток отработал за "+ (System.currentTimeMillis() - a)+" ms");
    }
    static void twoThread(float arr[]){

        float firstArr[] = new float[h];
        float secondArr[]= new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr,0,firstArr,0,h); // arracopy(откуда,c какой позиции,куда,с какой позиции вставка,количество)
        System.arraycopy(arr,h,secondArr,0,h);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < firstArr.length; i++) {
                    firstArr[i] = (float)(firstArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < secondArr.length; i++){
                    secondArr[i] = (float)(secondArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start(); t2.start();

        System.arraycopy(firstArr,0,arr,0,h);
        System.arraycopy(secondArr,0,arr,h,h);
        System.out.println("Два потока отработали за "+ (System.currentTimeMillis() - a)+" ms");
    }
}
