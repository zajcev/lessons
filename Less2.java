
package Less2;

import java.util.Scanner;

/**
 *
 * @author Sys_Adm
 */
public class Less2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 10; i <= 30; i += 10) 
            PlayLevel(i);
        System.out.println("WIN Test Commit");

        scanner.close();
    }

    private static void PlayLevel(int i) {
        int number = (int) (Math.random() * i);
        while (true) {
            System.out.println("Угадай число от 0 до " + i);
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("УгадаL");
                break;

            } else if (input_number > number) {
                System.out.println("More");
            } else if (input_number < number) {
                System.out.println("Less");

            } else {
                System.out.println("Это не число");

            }
        }
    }
}
