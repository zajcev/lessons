package Java_Lvl_2.Lesson_2;

public class DayOfWeekMain {

    public static void main(String[] args) {
    System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }
    private static int getWorkingHours(DayOfWeek day){
       int numDayOfWeek = day.ordinal() - 5;
     if (numDayOfWeek >= 0) return 0;
     else return numDayOfWeek * -8;
    }
}
