package Java_Lvl_3.Lesson_5;

import java.util.concurrent.Semaphore;

public abstract class Stage {

    protected int length;
    protected String description;
    protected Semaphore semaphore;

    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
