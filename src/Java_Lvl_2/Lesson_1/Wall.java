package Java_Lvl_2.Lesson_1;

public class Wall extends Obstacles {
    double weight;

    public Wall(double weight){ this.weight = weight; }

    @Override
    void doit(Does does) {
     does.jump(weight);
    }
}
