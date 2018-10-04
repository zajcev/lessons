package data;

public class HashMap {

    int size;
    LinkedHash[] table;

    HashMap(int size) {
        this.size = size;
        table = new LinkedHash[size];
        for (int i = 0; i < size; i++)
            table[i] = null;
    }

    private int hashFunc(int value) {
        return value % size;
    }
    private int hashFuncDouble(int value){
        return 19 - value % 19;
    }

    public int get(int value) {
        int step = hashFunc(value);
        int hash = hashFuncDouble(step);
        if (table[hash] == null)
            return -1;
        else {
            LinkedHash entry = table[hash];
            while (entry != null && entry.getValue() != value)
                entry = entry.getNext();
            if (entry == null)
                return -1;
            else
                return entry.getValue();
        }
    }

    /**
     *   Вообще делал так, но для проверки вывода следующего изменил на более наглядное.
     *   int step = hashFuncDouble(value);
     *   int hash = hashFunc(step);
     */

    public void put(int value) {

        int step = hashFunc(value);
        int hash = hashFuncDouble(step);
        if (table[hash] == null)
            table[hash] = new LinkedHash(value);
        else {
            LinkedHash entry = table[hash];
            while (entry.getNext() != null && entry.getValue() != value)
                entry = entry.getNext();
            if (entry.getValue() == value)
                entry.setValue(value);
            else
                entry.setNext(new LinkedHash(value));
        }
    }

    public void remove(int value) {

        int step = hashFunc(value);
        int hash = hashFuncDouble(step);

        if (table[hash] != null) {
            LinkedHash prevEntry = null;
            LinkedHash entry = table[hash];
            while (entry.getNext() != null && entry.getValue() != value) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getValue() == value) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }
        }
    }
    public void display(){
        System.out.println();
        LinkedHash[] hm = this.table;
        for (int i = 0; i < hm.length; i++){
            LinkedHash current = hm[i];
            if (hm[i] != null)
                System.out.print("[ ");
            while(current != null){
                current.display();
                current = current.getNext();
                if(current != null)
                    System.out.print(", ");
            }
            if (hm[i] != null)
                System.out.println("]");
        }
    }

public static void main(String[] args){

        HashMap hashMap = new HashMap(20);
        hashMap.put(10);
        hashMap.put(10);
        hashMap.put(20);
        hashMap.put(30);
        hashMap.put(40);
        hashMap.put(50);
        hashMap.put(60);
        hashMap.put(70);
        hashMap.put(75);
        hashMap.put(85);
        hashMap.put(95);
        hashMap.put(105);
        hashMap.display();
        hashMap.remove(10);
        hashMap.display();
        System.out.println();
        System.out.println(hashMap.get(100)); // Вернёт -1


    }
}
