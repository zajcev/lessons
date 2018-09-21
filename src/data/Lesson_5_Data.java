package src.data;

public class Lesson_5_Data {

    public static void main(String[] args){
        int[] w = {1,2,3};
        int[] c = {2,2,3};

        System.out.println(exponent(2,3));
        Bag bag = new Bag(4, w, c);
    }

    static int exponent(int i, int j){
        if (j == 0) return 1;
        return i * exponent(i, j -1);
    }
}

class Bag {
    static int maxSize;
    static int maxCost;
    static int bagSize;
    static int[] w;
    static int[] c;

public Bag(int bagSize, int[] w, int[] c){
   this.bagSize = bagSize;
   this.w = w;
   this.c = c;
   packBag(w.length);
}

    public static void packBag(int newSize) {
        if (newSize == 1)
            return;
        for (int i = 0; i < newSize; i++) {
            packBag(newSize - 1);
            if (newSize == 2) pack();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int i;
        maxCost = 0;
        maxSize = 0;
        int pos = w.length - newSize;
        int temp = w[pos];
        int tempC = c[pos];
        for (i = pos + 1; i < w.length; i++) {
            w[i - 1] = w[i];
            c[i - 1] = c[i];
        }
        w[i - 1] = temp;
        c[i -1] = tempC;
    }

    public static void pack() {
        for (int i = 0; i < w.length ; i++) {
            maxSize += w[i];
            maxCost += c[i];
            System.out.println("Положим " + w[i]);
            if (maxSize > bagSize){
                maxSize -= w[i];
                maxCost -= c[i];
                System.out.println("Не влез " + w[i]);
                continue;
            }
        }
        System.out.println("Вес " +maxSize+ " Стоимость " + maxCost);  System.out.println();
    }
}

