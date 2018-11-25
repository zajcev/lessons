package Java_Lvl_3.Lesson_6.Dop_Task;

import java.util.concurrent.CountDownLatch;

public class Ship implements Runnable {
    private  int count;
    private Shipment shipment;
    private int capacity;
    private Berth berth;
    private String name;
    private int weight = 0;
    private CountDownLatch latch;

    public Ship(int count,Shipment shipment, int capacity, Berth berth,CountDownLatch latch){
        this.count = count;
        this.shipment = shipment;
        this.capacity = capacity;
         this.berth = berth;
         name = count +" "+ berth.type;
         this.latch = latch;
    }
   public String getName(){
        return name;
   }
   public void setWeight(int cargo){
        weight += cargo;
   }
   public int getCapacity(){
        return capacity;
   }
   public int getWeight(){
        return weight;
   }
   public String getShipType(){
        return berth.type;
   }
    @Override
    public void run() {
        while (berth.capacity != 0) {
            for (int i = 0; i < shipment.getStages().size(); i++) {
                if (berth.capacity == 0 && weight == 0) break;
                shipment.getStages().get(i).startWork(this);
            }
        }
        latch.countDown();
    }
}
