package Java_Lvl_3.Lesson_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Server();
    }

    private ServerSocket server;
    private Socket socket;

    ObjectInputStream readObj;


    public Server() {
        try {
            server = new ServerSocket(8080);
            socket = server.accept();
            readObj = new ObjectInputStream(socket.getInputStream());
                try {
                        Student student = (Student) readObj.readObject();
                        System.out.println("id: " + student.id + " Name: " + student.name);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

