package data;

/**
 * Алгоритмы и структуры данных
 * Решение дз 3-го урока
 * @author Михаил Зайцев
 */

public class Lesson_3_Data {

    public static void main(String args[]){
        Stack stack = new Stack(5);
        Queue queue = new Queue(5);
        PriorityQueue priorityQueue = new PriorityQueue(5);
        String rofl = "ьлескев";
        Deq deq = new Deq(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.print("data.Stack: ");
        while (!stack.isEmpty()){
            int item = stack.pop();
            System.out.print(item + " ");
        }
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        System.out.println();
        System.out.print("data.Queue: ");
        while (!queue.isEmpty()){
            int item = queue.remove();
            System.out.print(item + " ");
        }
        priorityQueue.insert(1);
        priorityQueue.insert(3);
        priorityQueue.insert(2);
        priorityQueue.insert(5);
        priorityQueue.insert(4);
        System.out.println();
        System.out.print("data.PriorityQueue: ");
        while (!priorityQueue.isEmpty()){
            int item = priorityQueue.remove();
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(roll(rofl));

//        deq.insertLeft(1);
//        deq.insertLeft(2);
//        deq.insertLeft(3);
//        deq.insertLeft(4);
//        deq.insertLeft(5);
        deq.insertRight(1);
        deq.insertRight(2);
        deq.insertRight(3);
        deq.insertRight(4);
        deq.insertRight(5);
        System.out.println();
        System.out.println("data.Deq: ");
        while (!deq.isEmpty()){
            int item = deq.removeLeft();
            System.out.print(item + " ");
        }
    }

    public static char[] roll(String str){
        char[] symb = str.toCharArray();
        int last = symb.length -1;
        char memory = 0;
        double mid = symb.length / 2;
        for (int i = 0; i < mid; i++) {
            memory = symb[i];
            symb[i] = symb[last];
            symb[last] = memory;
            last--;
        }
        return symb;
    }
}
