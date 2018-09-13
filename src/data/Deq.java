package data;

public class Deq {
    private int maxSizeD;
    private int start;
    private int end;
    private int[] arrayD;
    private int items;

    public Deq(int i){
       maxSizeD = i;
       arrayD = new int[maxSizeD];
       start = 0;
       end = - 1;
       items = 0;
    }
    public boolean isFull(){
        return (items == maxSizeD - 1);
    }
    public boolean isEmpty(){
        return (items == 0);
    }
    public void insertRight(int i){
        if(end == maxSizeD - 1)
            end = -1;
        arrayD[++end] = i;
        items++;
    }
    public void insertLeft(int i){
        if(start == 0)
            start = maxSizeD;
        arrayD[--start] = i;
        items++;
    }

    public int removeLeft(){
        if (start == maxSizeD)
            start = 0;
        int temp = arrayD[start++];
        items--;
        return temp;
    }
    public int removeRight(){
        if (end == - 1)
            end = maxSizeD - 1;
        int temp = arrayD[end--];
        items--;
        return temp;
    }

}
