package Java_Lvl_2.Lesson_1;

public class Water extends Obstacles {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    void doit(Does does) {
       does.swim(length);
    }
}
