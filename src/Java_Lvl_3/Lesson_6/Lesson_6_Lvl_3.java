package Java_Lvl_3.Lesson_6;

import java.util.ArrayList;

public class Lesson_6_Lvl_3 {

 public int[] afterFour(int[] a){
     if (a.length == 0) throw new RuntimeException("Пустой массив");
     ArrayList<Integer> memory = new ArrayList<>();
     int marker = 0;
     int trigger = 0;
     for (int i = 0; i < a.length ; i++) {
         if (a[i] == 4){
             marker = i;
             trigger++;
         }
     }
     if (trigger == 0) throw new RuntimeException("В массиве нет ни одной четвёрки");
     for (int i = 1; i < a.length - marker ; i++) {
        memory.add(a[marker + i]);
     }
     int[] result = new int[memory.size()];

     for (int i = 0; i < memory.size(); i++) {
         result[i] = memory.get(i);
     }
        return result;
 }
 public  boolean oneAndFour(int a[]){
     int one = 0;
     int four = 0;
        for ( int i: a) {
         if (i == 1) one++;
         if (i == 4) four++;
     }
     if (one != 0 && four != 0) return true;

        return false;
 }
}
