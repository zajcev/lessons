package data;


class QueueGraph{
    private int maxSizeQueue;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public QueueGraph(int s){
        maxSizeQueue = s;
        queue = new int[maxSizeQueue];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty(){
        return (items == 0);
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

}

class Vertex{
    public char label;

    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph{
    private final int MAX_VERTS = 10;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }

    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void bfs(){
        QueueGraph queue = new QueueGraph(10);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        System.out.println();
        queue.insert(0); // Вставка в конец очереди
        int v2;
        int c = 0;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true; // Пометка
                displayVertex(v2); // Вывод
                c++;
                if (c == 3) {
                    System.out.println(); c = 0;}
                queue.insert(v2);
            }
        }
        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex].label+" ");
    }
}

public class Lesson_7_Data{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7
        graph.addVertex('I'); // 8
        graph.addVertex('J'); // 9

        graph.addEdge(0, 1); //AB
        graph.addEdge(0, 2); //AC
        graph.addEdge(0, 3); //AD
        graph.addEdge(1, 6); //BG
        graph.addEdge(6, 7); //GH
        graph.addEdge(7, 8); //HI
        graph.addEdge(2, 4); //CE
        graph.addEdge(4, 5); //EF
        graph.addEdge(3, 9); //DJ
        /*
           B  G  H  I

       A   C  E  F

           D  J
         */

        graph.bfs();
    }
}
