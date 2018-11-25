package Java_Lvl_3.Lesson_6.Dop_Task;

import java.util.concurrent.Semaphore;

public class WareHouse extends Work{
    int clothes;
    int food;
    int fuel;
    Semaphore semaphore = new Semaphore(1);

    public WareHouse(){
         this.description = "У склада";
    }

    @Override
    public void startWork(Ship ship) {
        try {
           // System.out.println("Корабль "+ship.getName() +" у склада(ждёт)");
            semaphore.acquire();
          //  System.out.println("Корабль "+ship.getName() +" разгружается");
            while (ship.getWeight() != 0){
                ship.setWeight(-100);
                switch (ship.getShipType()){
                    case "Clothes":
                        clothes += 100;
                        Thread.sleep(1000);
                        break;
                    case "Food":
                        food += 100;
                        Thread.sleep(1000);
                        break;
                    case "Fuel":
                        fuel += 100;
                        Thread.sleep(1000);
                        break;
                }
            }
            System.out.println(ship.getName() + " разгрузился");
            System.out.println("На складе --> Одежды: "+clothes+" Еды: "+food+" Топлива: "+fuel);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
