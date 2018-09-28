package data;

class StackTree {
    private int maxSize;
    private Node[] stack;
    private int top;

    public StackTree(int size) {
        this.maxSize = size;
        this.stack = new Node[this.maxSize];
        this.top = -1;
    }

    public void push(Node n) {
        this.stack[++this.top] = n;
    }

    public Node pop() {
        return this.stack[this.top--];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }
}

class Nums {
    public int num;

    public Nums(int num) {
        this.num = num;
    }
}

class Node{
    public Nums nums;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println(nums.num);
    }
}

class Tree{

    private Node root;

    boolean maxLvl;
    int left = 1;
    int right = 1;

    public void insert(Nums nums){
        Node node = new Node();
        node.nums = nums;
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (nums.num < current.nums.num){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        rightOrder(node);
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        leftOrder(node);
                        return;
                    }
                }
            }
        }
    }

    public void displayTree(){
        StackTree stack = new StackTree(1000);
        stack.push(root);
        int nBlanks = 10;
        boolean isRowEmpty = false;
        while (isRowEmpty == false) {
            StackTree localStack = new StackTree(1000);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.println(" ");
            }
            while (stack.isEmpty() == false) {
                Node temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.print(" ");
            nBlanks = nBlanks/2;
            while (localStack.isEmpty() == false) {
                stack.push(localStack.pop());
            }
        }

    }

    /**
     * если узлов слева или справа будет 6 то закончится вставка чисел
     */
    private void leftOrder(Node rootNode){
        if(rootNode != null){
            left++;
            if (left == 6){
                maxLvl = true;
                left = 1;
            }
            leftOrder(rootNode.leftChild);
        }
    }
    private void rightOrder(Node rootNode){
        if(rootNode != null){
            right++;
            if (right == 6){
                maxLvl = true;
                right = 1;
            }
            rightOrder(rootNode.rightChild);
        }
    }

}

public class Lesson_6_Data {

    public static void main(String[] args){

        int numOfTree = 1;
        for (int c = 0; c < 20; c++) {
            Tree theTree = new Tree();
           while (theTree.maxLvl == false){
                int r = -100 + (int) (Math.random() * 100);
                theTree.insert(new Nums(r));
            }
            System.out.println("                 "+numOfTree+"-e Дерево ");
            System.out.println("----------------------------------------------------------"); System.out.println();
            numOfTree++;
            theTree.displayTree();
            System.out.println("----------------------------------------------------------");
        }

    }
}

