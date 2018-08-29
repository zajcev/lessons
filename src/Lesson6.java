/**
 * Решение дз 5-го урока
 * @author Михаил Зайцев
 *
 */

public class Lesson6 {

    public static void main(String args[]) {
        Animal[] animals = { new Cat(100, 100, 2), new Dog(100,100,0.5) };

        for(Animal animal : animals){
            int i = 1;
            System.out.println( "Animal number " + i +  " - Run: " + animal.running() + " Swim: " + animal.swimming() + " Jump: " + animal.jumping());
            i++;
        }
    }
}

/**
 * Интерфейс с методами бега, плавания, прыжков
 */
interface IAnimal{

    abstract boolean running();

    abstract boolean swimming();

    abstract boolean jumping();

}

    class Animal implements IAnimal {

    /**
     * @param lengthRun - длина для бега
     * @param lengthSwim - длина для плавания
     * @param  height - высота для прыжков
     */

    int lengthRun;
    int lengthSwim;
    double height;
/**
 *  Конструктор для создания обьекта животного
 */
    Animal(int lengthRun, int lengthSwim, double height){
        this.lengthRun = lengthRun;
        this.lengthSwim = lengthSwim;
        this.height = height;
}

        /**
         * Переопределённый методы из интерфейса IAnimal
         */
        @Override
        public boolean running() {
            return false;
        }

        @Override
        public boolean swimming() {
            return false;
        }

        @Override
        public boolean jumping() {
            return false;
        }


    }

    class Dog extends Animal {
        /**
         *  Конструктор для создания обьекта собака
         */
        Dog(int lengthRun, int lengthSwim, double height) {
            super(lengthRun, lengthSwim, height);
        }

     public boolean running() {
            if(lengthRun > 500) {
                return false;
            }
            return true;
        }

        public boolean jumping() {
            if(height > 0.5) {
                return false;
            }
            return true;
        }

        public boolean swimming() {
            if (lengthSwim > 10){
                return false;
            }
            return true;
        }

    }

    class Cat extends Animal {
        /**
         *  Конструктор для создания обьекта кот
         */
        Cat(int lengthRun, int lengthSwim, double height) {
            super(lengthRun, lengthSwim, height);
        }

        public boolean running() {
            if(lengthRun > 200) {
                return false;
            }
            return true;
        }

        public boolean jumping() {
            if(height > 2) {
                return false;
            }
            return true;
        }

        public boolean swimming() {
            return false;
        }
    }

