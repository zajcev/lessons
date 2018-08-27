
/**
 * Решение дз 5-го урока
 * @author Михаил Зайцев
 *
 */

public class Lesson5 {

    public static void main(String args[]) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Something", "some@lala.com", "123412412", 30000, 30);
        persArray[1] = new Person("Titov Aleksey", "Else", "else@lala.com", "24124244", 20000, 20);
        persArray[2] = new Person("Monin Vladislav", "Cook", "Cook@lala.com", "234734743", 50000, 45);
        persArray[3] = new Person("Kamazov Stepan", "Man", "Man@lala.com", "6967967967", 80000, 27);
        persArray[4] = new Person("Zhmishenko Valeriy", "Boss", "boss@lala.com", "010101001", 100000, 50);
        Person person = new Person();
        person.printed(persArray);
    }


}

class Person {

    String name;
    String position;
    String email;
    String number;
    int salary;
    int age;

    Person(String name, String position, String email, String number, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }
    Person(){

    }

    void printed(Person[] p) {
     for(int i = 0; i < 5; i++) {
       if (p[i].age > 40){
           System.out.println("Name: " + p[i].name + "  Position: " + p[i].position + " Email: " + p[i].email + " Number: " + p[i].number +
                   " Salary: " + p[i].salary + " Age: " + p[i].age);
       }
     }
    }
}


