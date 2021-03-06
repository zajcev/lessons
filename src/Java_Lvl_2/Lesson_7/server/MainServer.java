package Java_Lvl_2.Lesson_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainServer {

    Vector<ClientHandler> clients;

    String currentTime;
    boolean toDeactivate = false;

    Logger logger = Logger.getLogger("ServerLogs");
    FileHandler file;

    public MainServer() throws SQLException {

        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            file = new FileHandler("C:/ServerLog.txt");
            logger.addHandler(file);
            SimpleFormatter formatter = new SimpleFormatter();
            file.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            logger.info("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                logger.info("Клиент подключился!");
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
        String message = currentTime + " " + msg;
        try {
            AuthService.saveChatHistory(message,sender,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (ClientHandler client: clients) {
            if (!AuthService.checkBlock(client.getNick(),sender))
            client.sendMsg(message);
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
            if (!AuthService.checkBlock(recipient,sender)) {
                String message = currentTime + " " + msg;
                client.sendMsg(message);
                try {
                    AuthService.saveChatHistory(message,sender,recipient);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                client.sendMsg("Пользователь " + recipient + " вас заблокировал");
            }
        if (client.getNick().equals(recipient)) { // Показать получателю
            if (!AuthService.checkBlock(recipient, sender))
                client.sendMsg(currentTime + " " + msg);
        }
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
    public void viewChat(ClientHandler client){
        try {
            Vector<Msg> messages = AuthService.getChatHistory();
            for (Msg msg : messages) {
                if (!AuthService.checkBlock(client.getNick(),msg.sender)){
                    client.sendMsg(msg.msg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
