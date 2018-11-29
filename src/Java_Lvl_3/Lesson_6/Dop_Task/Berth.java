package Java_Lvl_3.Lesson_6.Dop_Task;


import java.util.concurrent.Semaphore;

public class Berth extends Work{
    Semaphore semaphore = new Semaphore(1);
    String type;
    int capacity;

    public Berth(String type,int capacity){
     this.type = type;
     this.capacity = capacity;
     this.description = " У верфи " + type;
    }

    @Override
    public void startWork(Ship ship) {
        try {
           System.out.println(ship.getName() + description);
            if (capacity != 0) {
                semaphore.acquire();
                while (capacity != 0) {
                    if (ship.getWeight() == ship.getCapacity()) break;
                    capacity -= 100;
                    ship.setWeight(100);
                    Thread.sleep(1000);
                }
                  System.out.println(ship.getName() + " загрузился");
                  System.out.println("У верфи " + type + " осталось " + capacity);
                  semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
