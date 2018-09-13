package data;

public class Queue {
    /**
     * @param maxSizeQueue - максимыльный размер очереди
     * @param queue - массив для реализации очереди
     * @param front - маркер начала очереди
     * @param rear  - маркер конца очереди
     * @param items - количество элементов
     */
    private int maxSizeQueue;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s){
        maxSizeQueue = s;
        queue = new int[maxSizeQueue];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty(){
        return (items == 0);
    }

    public boolean isFull(){
        return (items == maxSizeQueue);
    }

    public int size(){
        return items;
    }

    public void insert(int i){
        if(rear == maxSizeQueue - 1)
        rear = -1;
        queue[++rear] = i;
        items++;
    }

    public int remove(){
        int temp = queue[front++];
        if (front == maxSizeQueue)
        front = 0;
        items--;
        return temp;
    }

    public int peek(){
        return queue[front];
}

}
