package data;

public class HashTable {
    Item[] hashArray;
    private int arrSize;
    private final Item nullItem;

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArray = new Item[arrSize];
        this.nullItem = new Item(-1);
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            sb.append((hashArray[i] != null) ? hashArray[i].getKey() : " *,");
        }
        return sb.toString();
    }
    private int hashFuncDouble(int key){
        return 19 - key % 19;
    }


    public void insert(Item item) {
        int key = item.getKey();
        int stepSize = hashFuncDouble(key);
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null && hashArray[hashVal] != nullItem) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArray[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = nullItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }
}

//    public Item find(int key) {
//        int hashVal = hashFunc(key);
//        int stepSize = hashFuncDouble(key);
//        while (hashArray[hashVal] != null) {
//            if (hashArray[hashVal].getKey() == key)
//                return hashArray[hashVal];
//
//            hashVal += stepSize;
//            hashVal %= arrSize;
//        }
//        return null;
//    }