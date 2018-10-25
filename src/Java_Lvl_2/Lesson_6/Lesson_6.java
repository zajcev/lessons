package Java_Lvl_2.Lesson_6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Lesson_6 {
    public static void main(String[] args) {
new Server(8189);
    }
}
class Server{

    ServerSocket server;
    Socket socket;

    Thread t1;
    Thread t2;


    public Server(int PORT){
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server Started");

            socket = server.accept();
            System.out.println("Client connected");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner console = new Scanner(System.in);

            t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true) {
                        if (in.hasNext()) {
                            String str = in.nextLine();
                            if (str.equals("/exit")){
                            System.out.println("Client disconnect from app");
                            break;
                            }
                            if(t2.isAlive())
                            System.out.println("Client: " + str);
                        }
                    }
                }
            });
            t2 = new Thread(new Runnable() {
               @Override
               public void run() {
                   while (console.hasNext()){
                           String servMsg = console.nextLine();
                           if (servMsg.equals("/exit")){
                               out.println("Client disconnect from server");
                               out.flush();
                               break;
                           }
                           if (t1.isAlive()) {
                               out.println("Server: " + servMsg);
                               out.flush();
                           }
                   }
               }
            });
           t1.start(); t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}