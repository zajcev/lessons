package data;

class Link{
    public String name;
    public int age;

    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}
class LinkedList {
    public Link first;
    public Link last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }
    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }
    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }



    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        if (this.isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }
    public void insertLast(String name, int age){
        Link newLink = new Link(name, age);
        if (this.isEmpty()){
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    public void insertStack(String name, int age){
        Link newLink = new Link(name, age);
        newLink.next = first;
        first = newLink;
    }
    public void insertQ(String name, int age){
        Link newLink = new Link(name, age);
        if (this.isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }


    public Link delete(){

        Link temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;

    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
    public Link find(String name){
        Link current = first;
        while(current.name != name){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(String name){
        Link current = first;
        Link previous = first;
        while(current.name != name){
            if(current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
    public String deleteQ(){
        Link temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp.name;

    }


}
class StackList {
    private LinkedList list;

    public StackList() {
        list = new LinkedList();
    }

    public void push(String name, int age) {
        list.insertStack(name, age);
    }

    public String pop() {
        return list.delete().name;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.display();
    }
    }
class QueueLink {
    private LinkedList queue;

    public QueueLink() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(String name, int age) {
        queue.insertQ(name, age);
    }

    public String delete() {
        return queue.deleteQ();
    }

    public void display() {
        queue.display();
    }
}
class LinkInterator {
    private Link current;
    private Link previous;
    private LinkedList list;

    public LinkInterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(String name, int age) {
        Link newLink = new Link(name, age);
        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String name, int age) {
        Link newLink = new Link(name, age);
        if (previous == null) {
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent() {
        String name = current.name;
        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }

        return name;
    }
}

        public class Lesson_4_Data {
            public static void main(String[] args) {
                LinkedList list = new LinkedList();
                list.insert("Artem", 30);
                list.insert("Misha", 10);
                list.insert("Vova", 5);
                list.insertLast("Petya", 25);
                System.out.println("Список");
                list.display();
                System.out.println("Удаление элементов списка");
                list.delete("Vova");
                list.display();    System.out.println();

                StackList sl = new StackList();
                sl.push("Artem", 10);
                sl.push("Viktor", 20);
                sl.push("Sergey", 30);
                System.out.println("Stack");
                sl.display();
                while (!sl.isEmpty()) {
                    System.out.println("Элемент "+ sl.pop()+" удален из стека");
                }     System.out.println();


                QueueLink q = new QueueLink();
                q.insert("Artem", 10);
                q.insert("Viktor", 20);
                q.insert("Sergey", 30);
                System.out.println("Quene");
                q.display();
                while (!q.isEmpty()) {
                    System.out.println("Элемент "+ q.delete()+" удален из стека");
                }     System.out.println();

                LinkInterator itr = new LinkInterator(list);
                System.out.println("Начало Итератора");    System.out.println();
                list.display();      System.out.println();
                itr.insertBefore("Before", 20);
                System.out.println("Вставим до итератора и переставим сам итератор на этот элемент");
                System.out.println(); list.display();  System.out.println();


                itr.insertAfter("After 1", 10);
                itr.insertAfter("After 2", 10);
                System.out.println("Вставим после итератора");
                System.out.println(); list.display();
                System.out.println();

                itr.getCurrent();
                itr.deleteCurrent();
                System.out.println("Узнали текущий элемент, удалили. Переместили итератор на следующий элемент");
                System.out.println(); list.display();

            }

        }



