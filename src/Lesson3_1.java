import java.util.Random;
import java.util.Scanner;

/**
 * Решение 1 задачи 3-го урока
 * @author Михаил Зайцев
 *
*/
public class Lesson3_1 {

    public static void main(String args[]){
        /**
         * @param z - заданное число
         * @param num - введённое пользователем
         * @param exit - переменная для инициализации ответа
         */
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int z = r.nextInt(9);
        int exit = 0;

        do {
            System.out.println("Угадайте число от 0 до 9");
            for (int i = 0; i < 3; i++) {
                int num = scanner.nextInt();
                if (z > num) {
                    System.out.println("Меньше"); System.out.println();
                }
                if (z < num) {
                    System.out.println("Больше"); System.out.println();
                }
                if (z == num) {
                    System.out.println("Вы угадали"); System.out.println();
                  break;
                }
                if(i == 2 && z != num) {
                    System.out.println();
                    System.out.println("Вы не угадали, загаданное число было - " + z);
                    System.out.println();
                }
            }
            /**
             * цикл while для проверки ввода. Если ввели не 1 и не 0, то спросить снова
             * @param memory - переменная для инициализации ответа
             */
            while(true){
                System.out.println("Сыграть ещё? Да - 1, Нет - 0"); System.out.println();
                int memory = scanner.nextInt();
                if(memory == 1){
                    exit = 1;
                    break;
                }if (memory == 0){
                    exit = 2;
                    break;
                }
            }
        } while (exit != 2);
    }

}



