package Java_Lvl_3.Lesson_4;

public class Printer {
    int count = 1;

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new PrintLetter(printer,"A"));
        Thread t2 = new Thread(new PrintLetter(printer,"B"));
        Thread t3 = new Thread(new PrintLetter(printer,"C"));
        t1.start(); t2.start(); t3.start();
    }
}
class PrintLetter implements Runnable{
    String letter;
    Printer printer;

    public PrintLetter(Printer printer,String letter){
        this.printer = printer;
        this.letter = letter;
    }

    @Override
    public void run() {
        if (letter.equals("A")){
            synchronized (printer) {
                for (int i = 0; i < 5; i++) {
                while (printer.count != 1) {
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(letter);
                printer.count = 2;
                printer.notifyAll();
            }
            }
        }else if (letter.equals("B")){
            synchronized (printer){
                for (int i = 0; i < 5; i++) {
                    while (printer.count != 2) {
                        try {
                            printer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(letter);
                    printer.count = 3;
                    printer.notifyAll();
                }
            }
        }else if (letter.equals("C")){
            synchronized (printer) {
                for (int i = 0; i < 5; i++) {
                    while (printer.count != 3) {
                        try {
                            printer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(letter);
                    printer.count = 1;
                    printer.notifyAll();
                }
            }
        }
    }
}