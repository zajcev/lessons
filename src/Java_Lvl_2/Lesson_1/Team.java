package Java_Lvl_2.Lesson_1;

public class Team {
    String teamName;
    Does[] team;

    Team(String teamName) {
        this.teamName = teamName;
        Does[] team = {new People("Ivan", 10, 2, 10),
                new People("Vasya", 1, 1, 1),
                new People("Dmitry", 1, 1, 1),
                new People("Oleg", 1, 1, 1),
        };
     this.team = team;
    }

    public void viewTeam() {
        System.out.println(teamName);
        for (Does d: team) {
            d.info();
        }
    }

    public void viewCourse() {
        System.out.println(teamName);
        for (Does d: team) {
          if (d.checkCourse())
            d.info();
        }
    }
}