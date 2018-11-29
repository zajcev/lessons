package Java_Lvl_3.Lesson_6.Dop_Task;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        CountDownLatch latch = new CountDownLatch(15);
        WareHouse wareHouse = new WareHouse();

        Berth clothes = new Berth("Clothes",2700);
        Berth food = new Berth("Food",5900);
        Berth fuel = new Berth("Fuel",8500);

        Shipment shipmentClothes = new Shipment(tunnel,clothes,tunnel,wareHouse);
        Shipment shipmentFood = new Shipment(tunnel,food,tunnel,wareHouse);
        Shipment shipmentFuel = new Shipment(tunnel,fuel,tunnel,wareHouse);

        Ship clothesShips[] = new Ship[2];
        Ship foodShips[] = new Ship[5];
        Ship fuelShips[] = new Ship[8];


        for (int i = 0; i < clothesShips.length ; i++) {
            clothesShips[i] = new Ship(i+1,shipmentClothes,500,clothes,latch);
        }
        for (int i = 0; i < foodShips.length ; i++) {
            foodShips[i] = new Ship(i+1,shipmentFood,500,food,latch);
        }
        for (int i = 0; i < fuelShips.length ; i++) {
            fuelShips[i] = new Ship(i+1,shipmentFuel,500,fuel,latch);
        }

        for (int i = 0; i < clothesShips.length; i++) {
            new Thread(clothesShips[i]).start();
        }
        for (int i = 0; i < foodShips.length ; i++) {
            new Thread(foodShips[i]).start();
        }
        for (int i = 0; i < fuelShips.length ; i++) {
            new Thread(fuelShips[i]).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все товары перевезены на склад");
    }
}
