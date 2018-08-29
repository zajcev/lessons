import java.util.Random;

/**
 * Решение дз 5-го урока
 * @author Михаил Зайцев
 *
 */

public class Lesson6 {

    public static void main(String args[]) {
        int i = 0;
        Animal[] animals = { new Cat(500, 100, 2),
                             new Dog(400,10,0.5),
                             new Dog(600, 10,1)};

        for(Animal animal : animals){
            i++;
            System.out.println( "Animal number " + i +  " - Run: " + animal.running() + " Swim: " + animal.swimming() + " Jump: " + animal.jumping());
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
         * Переопределённые методы из интерфейса IAnimal
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
         * @param runDog[] - массив для хранения длины бега
         * @param jumpDog[] - массив для хранения высоты прыжка
         * @param swimDog[] - массив для хранения длины плавания
         * @param z - рандомное число для выбора элемента массива длины плавания
         * @param j - рандомное число для выбора элемента массива высоты прыжка
         * @param s - рандомное число для выбора элемента массива длины плавания
         */
        int runDog[] = {400, 450, 500, 600};
        double jumpDog[] = {0.5, 1, 1.5, 2};
        int swimDog[] = {10, 15, 12, 5};
        Random r = new Random();
        int z = r.nextInt(4);
        int j = r.nextInt(4);
        int s = r.nextInt(4);


        Dog(int lengthRun, int lengthSwim, double height) {
            super(lengthRun, lengthSwim, height);
        }

     public boolean running() {
            if(lengthRun > runDog[z]) {
                return false;
            }
            return true;
        }

        public boolean jumping() {
            if(height > jumpDog[j]) {
                return false;
            }
            return true;
        }

        public boolean swimming() {
            if (lengthSwim > swimDog[s]){
                return false;
            }
            return true;
        }

    }

    class Cat extends Animal {
        /**
         * @param runCat[] - массив для хранения длины бега
         * @param jumpCat[] - массив для хранения высоты прыжка
         * @param z - рандомное число для выбора элемента массива длины
         * @param j - рандомное число для выбора элемента массива высоты
         */
        int runCat[] = {400, 450, 500, 600};
        double jumpCat[] = {0.5, 1, 1.5, 2};
        Random r = new Random();
        int z = r.nextInt(4);
        int j = r.nextInt(4);


        Cat(int lengthRun, int lengthSwim, double height) {
            super(lengthRun, lengthSwim, height);
        }

        public boolean running() {
            if(lengthRun > runCat[z]) {
                return false;
            }
            return true;
        }

        public boolean jumping() {
            if(height > jumpCat[j]) {
                return false;
            }
            return true;
        }

        public boolean swimming() {
            return false;
        }
    }

