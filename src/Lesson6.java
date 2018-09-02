import java.util.Random;

/**
 * Решение дз 5-го урока
 * @author Михаил Зайцев
 *
 */

public class Lesson6 {

    public static void main(String args[]) {
        Animal[] animals = { new Cat("Кот Мурзик",500, 100, 2),
                             new Dog("Пёс Шарик",400,10,0.5),
                             new Dog("Пёс Барон",600, 10,1)};

        for(Animal animal : animals){
            System.out.println( animal.name + " - Run: " + animal.running(animal.lengthRun) + " Swim: " + animal.swimming(animal.lengthSwim)
                    + " Jump: " + animal.jumping(animal.height));
        }
    }
}

/**
 * Интерфейс с методами бега, плавания, прыжков
 */
interface IAnimal{

    abstract boolean running(int run);

    abstract boolean swimming(int swim);

    abstract boolean jumping(double jump);

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
    String name;
/**
 *  Конструктор для создания обьекта животного
 */
    Animal(String name, int lengthRun, int lengthSwim, double height){
        this.name = name;
        this.lengthRun = lengthRun;
        this.lengthSwim = lengthSwim;
        this.height = height;
}
        /**
         * Переопределённые методы из интерфейса IAnimal
         */
        @Override
        public boolean running(int run) {
            return false;
        }

        @Override
        public boolean swimming(int swim) {
            return false;
        }

        @Override
        public boolean jumping(double jump) {
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
        String name;
        int runDog[] = {400, 450, 500, 600};
        double jumpDog[] = {0.5, 1, 1.5, 2};
        int swimDog[] = {10, 15, 12, 5};
        Random r = new Random();
        int z = r.nextInt(4);
        int j = r.nextInt(4);
        int s = r.nextInt(4);


        Dog(String name,int lengthRun, int lengthSwim, double height) {
            super(name, lengthRun, lengthSwim, height);
        }

     public boolean running(int run) {
            if(run > runDog[z]) {
                return false;
            }
            return true;
        }

        public boolean jumping(double jump) {
            if(jump > jumpDog[j]) {
                return false;
            }
            return true;
        }

        public boolean swimming(int swim) {
            if (swim > swimDog[s]){
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
        String name;
        int runCat[] = {400, 450, 500, 600};
        double jumpCat[] = {0.5, 1, 1.5, 2};
        Random r = new Random();
        int z = r.nextInt(4);
        int j = r.nextInt(4);


        Cat(String name, int lengthRun, int lengthSwim, double height) {
            super(name,lengthRun, lengthSwim, height);
        }

        public boolean running(int run) {
            if(run > runCat[z]) {
                return false;
            }
            return true;
        }

        public boolean jumping(double jump) {
            if(jump > jumpCat[j]) {
                return false;
            }
            return true;
        }

    }

