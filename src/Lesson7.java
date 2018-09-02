/**
 * Решение дз 7-го урока
 * @author Михаил Зайцев
 *
 */
public class Lesson7 {
    public static void main(String[] args){
    Cats[] cat = {  new Cats("Murzik", 10, false),
                    new Cats("Pushok", 50, false),
                    new Cats("James", 30, false) };
    Plate plate = new Plate(60);
        for (Cats cats : cat) {
            plate.info();
            cats.eat(plate);
            if (!cats.getSatiety()){
                System.out.println(cats.getName() + " не наелся, добавим еды в миску");
                plate.setFood(cats.getAppetite() - plate.getFood());
                plate.info();
                cats.eat(plate);
            }
            System.out.println(cats.getName() + " Наелся - " + cats.getSatiety());
        }

    }
}

class Plate {

    /**
     * @param food - количество еды
     */
    private int food;

    public  Plate(int food){
        this.food = food;
    }
    public boolean decreaseFood(int n){
        if((food - n) >= 0) {
            food -= n;
            return true;
        }
        return false;
    }
    public void info(){
        System.out.println("plate: " + food);
    }

    /**
     * метод для добавления еды в миску
     */
    public void setFood(int n){
        food += n;
    }

    /**
     * @return  - возвращает количество еды в миске
     */
    public int getFood(){
        return food;
    }
}

class Cats {
    /**
     * @param name - имя
     * @param appetite - сколько нужно для того что бы наелся кот
     * @param satiety - наелся ли кот
     */

    private String name;
    private int appetite;
    private boolean satiety;

    public Cats(String name, int appetite, boolean satiety){
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }
    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
        } else {
            satiety = false;
        }
    }

    /**
     * @return - имя
     */
    public String getName(){
        return name;
    }
    /**
     * @return - сытость
     */
    public boolean getSatiety(){
        return satiety;
    }
    /**
     * @return - сколько нужно для сытости
     */
    public int getAppetite(){
        return appetite;
    }
}