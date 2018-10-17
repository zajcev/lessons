package Java_Lvl_2.Lesson_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public  class PhoneNumbers {

 Map<String, LinkedList<Integer>> hm = new HashMap<>();

    public void add(String name, int phone){
        if (!hm.containsKey(name)){
            LinkedList<Integer> link = new LinkedList<>();
            link.addFirst(phone);
            hm.put(name,link);
        }else {
            hm.get(name).addLast(phone);
        }
    }

    public void get(String name){
        for (Integer i : hm.get(name)) {
            System.out.println(name+" "+ i);
        }
    }
}