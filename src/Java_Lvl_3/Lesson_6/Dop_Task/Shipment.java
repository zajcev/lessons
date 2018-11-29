package Java_Lvl_3.Lesson_6.Dop_Task;


import java.util.ArrayList;
import java.util.Arrays;

public class Shipment {
    private ArrayList<Work> works;

    public ArrayList<Work> getStages() {
        return works;
    }

    public Shipment(Work... stages) {
        this.works = new ArrayList<>(Arrays.asList(stages));
    }
}
