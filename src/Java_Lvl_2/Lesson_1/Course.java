package Java_Lvl_2.Lesson_1;

public class Course {

    int distSwim;
    double distJump;
    int distRun;
    Obstacles[] obstacles;

    Course(int distSwim, double distJump, int distRun) {
        this.distSwim = distSwim;
        this.distJump = distJump;
        this.distRun = distRun;
        Obstacles[] obstacles = {new Cross(distRun), new Wall(distJump), new Water(distSwim)};
        this.obstacles = obstacles;

    }


    public void doIt(Team team) {
        for (Obstacles o : obstacles){
         for (Does t : team.team){
             o.doit(t);
         }
        }
    }
}