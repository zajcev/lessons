package Java_Lvl_2.Lesson_7.server;

import org.sqlite.util.StringUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {

    private MainServer server;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;

    public ClientHandler(MainServer server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // цикл для авторизации
                        while (true) {
                            String str = in.readUTF();
                            if(str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if(!server.userOnline(newNick)) {
                                    if (newNick != null) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.broadCastMsg("Пользователь "+nick+" подключился");
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Неверный логин/пароль!");
                                    }
                                }else {
                                    sendMsg("Пользователь с таким логином уже в сети");
                                }
                            }
                        }
                        // цикл для работы
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                server.broadCastMsg(nick + " вышел из чата");
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            if (str.startsWith("/w")){
                            String nickName = splitNick(str);
                             if (server.userOnline(nickName)) {
                                String[] result = str.split(" ");
                                result[0] = ""; result[1] = "";
                                String msg = StringUtils.join(Arrays.asList(result)," ");

                                 server.sendToNick(nick, nickName,"( "+nick+" to "+nickName+" ) "+" :" + msg);
                             } else out.writeUTF("Пользователь не в сети");
                            }else {
                                server.broadCastMsg(nick + ": " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return вернёт nickName получателя
     */
    public String splitNick(String msg){
       String[] str = msg.split(" ");
       String nickName = str[1];
       return nickName;
    }

    public String getNick(){
        return nick;
    }
}
