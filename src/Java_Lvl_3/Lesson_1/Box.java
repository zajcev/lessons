package Java_Lvl_3.Lesson_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private T obj;
    ArrayList<T> box;

    public Box(T obj){
        this.obj = obj;
        this.box = new ArrayList<T>();
    }


public int getWeight(){
        return this.obj.weight * this.box.size();
}

public boolean compare(Box equal){
        return this.getWeight() == equal.getWeight();
}

public void replace(Box where){
        if (this.obj.getClass().getName().equals(where.obj.getClass().getName())){
            where.box.addAll(this.box);
            this.box.clear();
        }else System.out.println("Коробки с разными фруктами");
}

public void add(T obj) {
           if (this.obj.equals(obj))
            box.add(obj);
           else System.out.println("Тут должны лежать другие фрукты");
    }
}

