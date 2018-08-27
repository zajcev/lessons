import java.util.Random;
import java.util.Scanner;

/**
 * @author Михаил Зайцев
 * Решение домашнего задания к 4-ому уроку
 */

public class Lesson_4 {

    /**
     * @param SIZE - размер поля
     * @param DOTS_TO_WIN - клеток заполненых клеток для победы
     * @param DOT - точка(пустая клетка)
     * @param DOT_X - крестик
     * @param DOT_O - нолик
     * @param map - символьный массив для имитациии игрового поля
     * @param count - счётчик для подсчёта символов подряд
     */

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int count;

    public static void main(String args[]){
        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if(mapFull()){
                System.out.println("Draw");
                break;
            }
            if(checkWin(DOT_X)){
                System.out.println("Human win");
                break;
            }
            compTurn();
            printMap();
            if(mapFull()){
                System.out.println("Draw");
                break;
            }
            if(checkWin(DOT_O)){
                System.out.println("Computer win");
                break;
            }
        }
    }

    /**
     * Обнуление игрового поля
     */

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT;
            }
        }
    }

    /**
     * Печать игрового поля
     */

    public static void printMap(){
        System.out.print(" ");
        for(int i = 0; i < SIZE; i++){
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Проверка заполняемой клетки.
     * @return true если клетка не выходит за пределы массива и там точка
     */

    public static boolean isValid(int x, int y){
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
            return false;
        }
        if(map[x][y] == DOT) {
            return true;
        }
    return false;
    }

    /**
     * Заполнение клетки с клавиатуры с проверкой валидности введённых данных
     */

    public static void humanTurn(){
int x, y;
do{
    System.out.println("Введите координаты X и Y каждая из которых не должна быть больше чем " + SIZE);
    x = scanner.nextInt() -1;
    y = scanner.nextInt() -1;
}while(!isValid(x,y));
map[x][y] = DOT_X;
    }

    /**
     * Нолик в рандомную точку с проверкой валидности
     */

public static void compTurn(){
    int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
         }while (!isValid(x,y));
        map[x][y] = DOT_O;
}

    /**
     * Проверка заполнености карты
     */

public static boolean mapFull(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT){
                    return false;
                }
            }
        }
        return true;
}

/**
     * Проверка победы
     */

public static boolean checkWin(char symb){
    count = 0;
    /**
     * Проверка строк
     */
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if (map[i][j] == symb) {
                count++;
            }
            if(count == DOTS_TO_WIN){
                return true;
            }
            if(map[i][j] == DOT){
                count = 0;
            }
        }
        count = 0;
    }
    /**
     * Проверка столбцов
     */
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if (map[j][i] == symb) {
                count++;
            }
            if(count == DOTS_TO_WIN){
                return true;
            }
            if(map[j][i] == DOT){
                count = 0;
            }
        }
        count = 0;
    }
    /**
     * Проверка диагонали справа налево
     */
    for(int i = 0, j = (SIZE - 1); i < SIZE && j >= 0; i++, j--){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;

    for(int i = 0, j = (SIZE - 2); i < SIZE && j >= 0; i++, j--){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;

    for(int i = 1, j = (SIZE - 1); i < SIZE && j >= 0; i++, j--){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;

    /**
     * Проверка диагонали слева направо
     */
    for(int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return  true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;

    for(int i = 0, j = 1; i < SIZE && j < SIZE; i++, j++){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return  true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;

    for(int i = 1, j = 0; i < SIZE  && j < SIZE; i++, j++){
        if(map[i][j] == symb){
            count++;
        }
        if(count == DOTS_TO_WIN){
            return  true;
        }
        if(map[i][j] == DOT){
            count = 0;
        }
    }
    count = 0;
    return false;
}


}

