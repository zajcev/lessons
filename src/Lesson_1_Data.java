/**
 * Алгоритмы и структуры данных
 * Решение дз 1-го урока
 * @author Михаил Зайцев
 *
 */
public class Lesson_1_Data {

    public static void main(String[] args) {
        int[] min = {5, 10, 55, 10, 22};
        System.out.println(exponent(3, 3));
        System.out.println(average(20, 30));
        System.out.println(minNum(min));
    }

    /**
     * Среднее число
     */
    static int average(int a, int b) { // Если бы был массив было бы O(n)
        int c = (a + b) / 2;
        return c;
    }

    /**
     * Возведение числа в степень
     *
     * @param n - число
     * @param s - степень
     */
    static int exponent(int n, int s) { // O(n)
        int expo = n;
        int x = n;
        for (int i = 1; s > i; i++) {
            expo = x * n;
            x = expo;
        }
        return expo;
    }

    /**
     * Минимальное число из массива
     */
    static int minNum(int arr[]) { // O(n)
        int m = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (m > arr[i]){
                m = arr[i];
            }
        }
        return m;
    }
}
