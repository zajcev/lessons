import com.sun.xml.internal.fastinfoset.sax.SystemIdResolver;

import java.util.Random;

/**
 * @author Михаил Зайцев
 * Решение дз 2-ого урока
 */
public class Lesson_2_Data {

    public static void main(String args[]) {
        Arr arr = new Arr(10);
        long startTime = System.currentTimeMillis();
        arr.setNumsArray();
        System.out.println("Наполним массив");
        arr.display();
        System.out.println();
        System.out.println();
        System.out.println("Отсортируем");
        arr.sortInsert();
        arr.display();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime + " ms");

    }
}
class Arr{

    Random random = new Random();
    private int arrMillion[];
    private int size = 0;

    public Arr(int size){
        this.size = size;
        this.arrMillion = new int[size];
    }

    void setNumsArray(){
        for (int i = 0; i < this.size; i++) {
            int r = random.nextInt(11);
            arrMillion[i] = r;
        }
    }
    public void delete(int value) {
        int i;
        for (i = 0; i < this.size; i++){
            if(arrMillion[i] == value) break;
        }
        for (int j = i; j < this.size; j++) {
            this.arrMillion[j] = this.arrMillion[j + 1];
        }
        this.size--;
    }

  public void setNum(int index, int elem) {
        this.arrMillion[index] = elem;
    }

    public void display(){
        for (int arr : arrMillion) {
            System.out.println(arr);
        }
    }

    public boolean find(int value){
        int i;
        for (i = 0; i < this.size; i++){
            if(arrMillion[i] == value) break;
        }
        if(i == this.size){
            return false;
        }else{
            return true;
        }

    }
    public boolean binFind(int value){
        int low = 0;
        int mid;
        int high = this.size -1;
        while (low < high){
            mid = (low + high)/2;
            if(value == arrMillion[mid]){
                return true;
            } else {
            if(value < this.arrMillion[mid]){
                high = mid;
            } else {
                low = mid;
            }
            }
        }
        return false;
    }

    public void change(int a, int b){
        int tmp = this.arrMillion[a];
        this.arrMillion[a] = this.arrMillion[b];
        this.arrMillion[b] = tmp;
    }

    /**
     * Пузырьковая сортировка O(n^2)
     */
    public void sortBubble(){
        int out, in;
        for (out = this.size - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if(this.arrMillion[in] > this.arrMillion[in + 1]){
                    change(in, in + 1);
                }
            }
        }
    }
    /**
     * Сортировка методом выбора O(n^2)
     */
public void sortSelect(){
        int in, out, mark;
    for (out = 0; out < this.size; out++) {
        mark = out;
        for (in = out + 1; in < this.size; in++){
            if(this.arrMillion[in] < this.arrMillion[mark]){
                mark = in;
            }
        }
        change(out, mark);
    }
    }
    /**
     * Сортировка методом вставки O(n^2)
     */
    public void sortInsert(){
        int in, out;
        for (out = 1; out < this.size ; out++) {
            int temp = this.arrMillion[out];
            in = out;
            while (in > 0 && this.arrMillion[in - 1] >= temp){
                this.arrMillion[in] = this.arrMillion[in -1];
                in--;
            }
            this.arrMillion[in] = temp;
        }
    }
}