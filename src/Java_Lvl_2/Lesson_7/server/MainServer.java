package Java_Lvl_2.Lesson_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class MainServer {

    Vector<ClientHandler> clients;

    String currentTime;
    boolean toDeactivate = false;


    public MainServer() throws SQLException {

        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();
     new Thread(new Runnable() {
         @Override
         public void run() {
             while (true) {
                 Date date = new Date(System.currentTimeMillis());
                 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                 currentTime = dateFormat.format(date) + " ";
             }
         }
     }).start();
        try {
            AuthService.connect();

            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            AuthService.disconnect();
        }

    }

    public void broadCastMsg(String sender,String msg) {
        for (ClientHandler client: clients) {
            if (!AuthService.checkBlock(client.getNick(),sender))
            client.sendMsg(currentTime+" "+msg);
            }
        }

public boolean userOnline(String nick){
    for (ClientHandler client : clients) {
        if (client.getNick().equals(nick)){
            return true;
        }
    }
        return false;
}

    /**
     *
     * @param sender - Отправитель
     * @param recipient - Получатель
     * @param msg - Само сообщение
     */
    public void sendToNick(String sender,String recipient, String msg){
    for (ClientHandler client : clients ) {
        if (client.getNick().equals(sender)) // Показать сообщение отправителю
            if (!AuthService.checkBlock(recipient,sender))
                client.sendMsg(currentTime+" "+msg);
            else
                client.sendMsg("Пользователь "+recipient+" вас заблокировал");
        if (client.getNick().equals(recipient)) // Показать получателю
            if (!AuthService.checkBlock(recipient,sender))
            client.sendMsg(currentTime+" "+msg);
    }
}

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientsList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientsList();
    }

    public void broadcastClientsList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");
        for (ClientHandler o: clients) {
            sb.append(o.getNick() + " ");
        }
        String out = sb.toString();
        for (ClientHandler o: clients) {
            o.sendMsg(out);
        }
    }
    public boolean deactivate(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            toDeactivate = true;
            }
        },120*1000);
    return toDeactivate;
    }

}
