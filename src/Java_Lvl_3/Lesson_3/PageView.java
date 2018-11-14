package Java_Lvl_3.Lesson_3;

import java.io.*;
import java.util.Scanner;

public class PageView {
    public static void main(String[] args) throws IOException {
        String file = "page.txt";
        final int pageSize = 1800;
        byte[] page = new byte[pageSize];

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер страницы");
            int pageNumber = scanner.nextInt();

            long timeRead = System.currentTimeMillis();
            int seek = pageSize * (pageNumber - 1);

            RandomAccessFile separator = new RandomAccessFile(file, "r");
            if (separator.length() > seek){
                separator.seek(seek);
                separator.read(page);
                for (int j = 0; j < page.length; j++){
                    char symbol = (char) page[j];
                    System.out.print(symbol);
                }
                separator.close();
                System.out.println("\n" + "Время выполнения "+ (System.currentTimeMillis() - timeRead) +" ms"); // Максимальное время 50-55 ms
            }else System.out.println("Нет такой страницы");
        }
    }
}