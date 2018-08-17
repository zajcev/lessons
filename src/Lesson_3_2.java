import java.util.Random;
import java.util.Scanner;

/**
 * Решение 2 задачи 3-го урока
 * @author Михаил Зайцев
*/

public class Lesson_3_2 {

    public static void main(String args[]){
        /**
         * @param z - Рандомное слово из массива
         * @param w - Рандомный индекс для выбора слова из массива 
         * @param wish - Слово введённое пользователем
         * @param words[] - Массив со словами
         */
        String z;
        String wish;
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        String[] words = {"apple", "orange","lemon","banana","apricot","avocado","broccoli","carrot",
                "cherry","garlic","grape","melon","leak","kiwi","mango","mushroom","nut",
                "olive","pea","peanut","pear","pepper","pineapple","pumpkin","potato"};
        int random = words.length;
        int w = r.nextInt(random);
        System.out.println("Введите слово"); System.out.println();
        do {
            z = words[w];
            wish = scanner.next();
            for(int i = 0; i < z.length() && i < wish.length() ; i++){
               if(wish.charAt(i) == z.charAt(i)){
                   System.out.print(wish.charAt(i));
                }
                if(wish.charAt(i) != z.charAt(i)){
                   System.out.print("##");
               }
            }
            if(!wish.equals(z)) {
                System.out.print("#####");
                System.out.println(); System.out.println();
                System.out.println("Попробуйте ещё раз");
            }
        } while(!wish.equals(z));
        System.out.println(); System.out.println();
        System.out.println("Вы угадали");
    }
}
