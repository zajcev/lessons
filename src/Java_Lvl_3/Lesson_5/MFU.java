package Java_Lvl_3.Lesson_5;

import java.util.concurrent.Semaphore;

public class MFU {
    Semaphore print = new Semaphore(1);
    Semaphore scan = new Semaphore(1);

    public void print(String doc, int n) {
        try {
            print.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("Начало печати");
        try {
            Thread.sleep(50 * n);
            System.out.println(doc + " " + n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец печати");
        print.release();
    }

    public void scan(String doc, int n) {
        try {
            scan.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
          System.out.println("Начало сканирования");
        try {
            Thread.sleep(50 * n);
            System.out.println(doc + " " + n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("Конец сканирования");
        scan.release();
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Print 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Print 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Scan 1", 10);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Scan 2", 5);
            }
    }).start();

    }
}

