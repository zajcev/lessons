package Java_Lvl_2.Lesson_1;

class People implements Does{
    String name;
    int maxSwim;
    double maxJump;
    int maxRun;
    boolean checkCourse;


    People(String name, int maxSwim, double maxJump, int maxRun){
        this.name = name;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.checkCourse = true;
    }

    @Override
    public void run(int dist) {
        if (maxRun < dist)
            checkCourse = false;
        }

    @Override
    public void jump(double dist) {
        if (maxJump < dist)
            checkCourse = false;
    }

    @Override
    public void swim(int dist) {
        if (maxSwim < dist)
            checkCourse = false;
    }

    @Override
    public boolean checkCourse() {
        return checkCourse;
    }

    @Override
    public void info() {
        System.out.println(name+" "+checkCourse);
    }
}
