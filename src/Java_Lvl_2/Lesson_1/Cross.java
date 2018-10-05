package Java_Lvl_2.Lesson_1;

public class Cross extends Obstacles {
    int length;

    public Cross(int length){ this.length = length; }

    @Override
    void doit(Does does) {
     does.run(length);
    }
}
