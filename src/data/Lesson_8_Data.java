package data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lesson_8_Data {
    public static void main(String[] args){

//        ArrayList<String> al = new ArrayList<>();
//        for (int i = 0; i < 1_000_000 ; i++) {
//            al.add("Entry #" + i);
//        }
//        HashMap<String,Integer> hm = new HashMap<>();
//        for (int i = 0; i < 1_000_000 ; i++) {
//            hm.put("Entry #" + i, i);
//        }
//
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < 1_000_000 ; i++) {
//            al.contains("Entry #506434");
//        }
//        System.out.println(System.currentTimeMillis() - time);
//
//        long time2 = System.currentTimeMillis();
//        for (int i = 0; i < 1_000_000 ; i++) {
//            hm.containsKey("Entry #506434");
//        }
//        System.out.println(System.currentTimeMillis() - time2);
//
//        HashMap<String,String> hm2 = new HashMap<>();
//        hm2.put("One","Один");
//        hm2.put("Two","Два");
//        hm2.put("Three","Три");
//        String[] str = new String[16];
//        str[(str.length - 1) & "Java".hashCode()] = "JavaValue";
//        str[(str.length - 1) & "Home".hashCode()] = "HomeValue";
//        str[(str.length - 1) & "Core".hashCode()] = "CoreValue";
//
//        System.out.println(Arrays.toString(str));
//        System.out.println(2400058 % 10);
    HashTable hashTable = new HashTable(25);
        hashTable.insert(new Item(10));
        hashTable.insert(new Item(10));
        hashTable.insert(new Item(20));
        hashTable.insert(new Item(30));
        hashTable.insert(new Item(40));
        hashTable.insert(new Item(50));
        hashTable.insert(new Item(60));
        hashTable.insert(new Item(70));
        hashTable.insert(new Item(75));
        System.out.println(hashTable);
        hashTable.insert(new Item(100));
        System.out.println(hashTable);
        hashTable.delete(75);
        System.out.println(hashTable);
    }

}
