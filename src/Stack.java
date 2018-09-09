public class Stack {
    /**
     * @param maxSizeStack - максимальный размер стека
     * @param stack - стек реализованный через массив
     * @param top - вершина стека
     */
    private int maxSizeStack;
    private int[] stack;
    private int top;

    public Stack(int size){
      maxSizeStack = size;
      stack = new int[maxSizeStack];
      top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSizeStack - 1);
    }

     public void push(int i){
    this.stack[++top] = i;
    }

    public int pop(){
         return stack[top--];
    }

    public int peek(){
        return stack[top];
    }
}