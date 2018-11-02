package Java_Lvl_2.Lesson_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class MainServer {

    Vector<ClientHandler> clients;

    public MainServer() throws SQLException {

        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

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

    public void broadCastMsg(String msg) {
        for (ClientHandler o: clients) {
                o.sendMsg(msg);
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
            client.sendMsg(msg);
        if (client.getNick().equals(recipient)) // Показать получателю
            client.sendMsg(msg);
    }
}

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

}
