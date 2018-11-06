package Java_Lvl_3.Lesson_1;

/**
 * Решение дз 1-го урока Java_Lvl_3
 * @author Михаил Зайцев
 *
 */
public class MainClass {

    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box orangeBox = new Box(orange);
        Box appleBox = new Box(apple);
        Box testBox = new Box(apple);

        orangeBox.add(orange);
        orangeBox.add(orange);

        appleBox.add(apple);
        appleBox.add(apple);
        appleBox.add(apple);

        System.out.println("Вес фруктов в коробке " + appleBox.getWeight()); // Вес коробки
        System.out.println(orangeBox.compare(appleBox)); // Сравнение коробок по весу

        appleBox.replace(testBox); // Из одной коробки в другую
        System.out.println(testBox.getWeight());
    }
}
