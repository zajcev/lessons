package Java_Lvl_2.Lesson_1;

public class Lesson_1 {
    public static void main(String[] args) {
        Course course = new Course(10,2,10);
        Team team = new Team("Team_1");
        course.doIt(team);
        team.viewTeam();
       // team.viewCourse();
    }
}



