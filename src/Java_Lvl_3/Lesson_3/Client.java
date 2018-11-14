package Java_Lvl_3.Lesson_3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        new Client();
    }
    private Socket socket;

    ObjectOutputStream writeObj;
    public Client(){
        try {
            socket = new Socket("localhost",8080);
            writeObj = new ObjectOutputStream(socket.getOutputStream());

            Student student = new Student(1,"Test");
            writeObj.writeObject(student);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writeObj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Student implements Serializable {
    int id;
    String name;

    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }
}