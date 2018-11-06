package Java_Lvl_3.Lesson_1;

import java.util.ArrayList;

/**
 * Решение дз 1-го урока Java_Lvl_3
 * @author Михаил Зайцев
 *
 */
public class Lesson_1{

    public static void main(String[] args) {
        Arr arr = new Arr<>();

        String[] strArr = {"1","2","3","4","5"};
        Integer[] intArr = {1,2,3,4,5};

        ArrayList strList = arr.arrayToList(strArr);
        ArrayList intList = arr.arrayToList(intArr);
        System.out.println(strList);
        System.out.println(intList);
        System.out.println();

       arr.roll(strList,"1","3");
       arr.roll(intList,2,4);

    }

}
class Arr<T>{

    public Arr(){
    }
    void roll(ArrayList<T> arr, T first, T second) {
        try {
            int firstIndex = arr.indexOf(first);
            int secondIndex = arr.indexOf(second);
            arr.set(firstIndex, second);
            arr.set(secondIndex, first);
            System.out.println(arr);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    public ArrayList<T> arrayToList(T array[]){
        ArrayList<T> newList = new ArrayList();
        for (T elem : array) {
            newList.add(elem);
        }
        return newList;
    }
}


