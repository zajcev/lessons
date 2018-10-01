package data;

public class LinkedHash {
    private int value;
    private LinkedHash next;

    LinkedHash(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedHash getNext() {
        return next;
    }

    public void setNext(LinkedHash next) {
        this.next = next;
    }
    public void display(){
        System.out.print(this.value + " ");
    }
}