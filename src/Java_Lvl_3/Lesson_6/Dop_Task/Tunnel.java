package Java_Lvl_3.Lesson_6.Dop_Task;

import java.util.concurrent.Semaphore;

public class Tunnel extends Work {
    Semaphore semaphore = new Semaphore(2);
    public Tunnel(){}
    @Override
    public void startWork(Ship ship) {
        try {
            try {
                System.out.println("Корабль "+ship.getName() +" у пролива(ждёт)");
                semaphore.acquire();
                System.out.println("Корабль "+ship.getName() +" заплыл в пролив");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Корабль "+ship.getName()+" проплыл пролив");
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
