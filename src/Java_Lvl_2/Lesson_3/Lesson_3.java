package Java_Lvl_2.Lesson_3;

import java.util.*;

public class Lesson_3 {

    private static void getNames(ArrayList<String> al){
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < al.size(); i++) {
            Integer res = hm.get(al.get(i));
            hm.put(al.get(i), res == null ? 1 : res + 1); // если res null то ставим 1, если нет то прибавляем 1 к res
        }
        System.out.println(hm+"\n");
    }

    public static void main(String[] args) {
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        ArrayList<String> al = new ArrayList<>();
        al.add("Victor");
        al.add("Petya");
        al.add("Petya");
        al.add("Vasya");
        al.add("Artur");
        al.add("Vasya");
        al.add("Gena");
        al.add("Victor");
        al.add("Misha");
        al.add("Vasya");
        al.add("Vasya");
        getNames(al);

        phoneNumbers.add("Petrov", 1234);
        phoneNumbers.add("Petrov", 5678);
        phoneNumbers.add("Petrov", 8907);
        phoneNumbers.add("Petrov", 1239);
        phoneNumbers.add("Vasin", 1234);
        phoneNumbers.add("Vasin", 1234);
        phoneNumbers.add("Chizhov", 1234);

        phoneNumbers.get("Vasin");
        phoneNumbers.get("Petrov");
        phoneNumbers.get("Chizhov");
    }
}
