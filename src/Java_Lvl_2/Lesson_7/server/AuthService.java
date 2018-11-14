package Java_Lvl_2.Lesson_7.server;

import java.sql.*;
import java.util.Vector;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void saveChatHistory(String msg, String sender,String whom) throws SQLException {
        String sql = String.format("INSERT INTO MSG (message, sender, whom)" +
                "VALUES ('%s','%s','%s')",msg,sender,whom);
        stmt.execute(sql);
    }
    public static Vector<Msg> getChatHistory() throws SQLException {
        Vector<Msg> messages = new Vector<>();

        String sql = String.format("SELECT message,sender,whom FROM MSG");
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
                Msg msg = new Msg(rs.getString("message"), rs.getString("sender"), rs.getString("whom"));
                messages.add(msg);
        }
       return messages;
    }

    public static void addUsers(String login, String pass, String nick) throws SQLException {
        String sql = String.format("INSERT INTO USERS (login, password, nickname)" +
                "VALUES ('%s','%s','%s')", login, pass.hashCode(), nick);
        stmt.execute(sql);
    }
    public static void renameUser(String oldNick, String newNick) throws SQLException {
        String sql = String.format("UPDATE USERS SET nickname = '%s' WHERE nickname = '%s'",newNick,oldNick);
        String nickname = String.format("UPDATE BLACKLIST SET nickname = '%s' WHERE nickname = '%s'",newNick,oldNick);
        String blacklist = String.format("UPDATE BLACKLIST SET blacklist = '%s' WHERE blacklist = '%s'",newNick,oldNick);
        String chatHistory = String.format("UPDATE MSG SET sender = '%s' WHERE sender = '%s'",newNick,oldNick);
        stmt.execute(sql);
        stmt.execute(nickname);
        stmt.execute(blacklist);
        stmt.execute(chatHistory);
    }

    public static void addBlock(String sender,String blockNick) throws SQLException {
        String sql = String.format("INSERT INTO BLACKLIST (nickname, blacklist)" +
                "VALUES('%s','%s')",sender,blockNick);
        stmt.execute(sql);
    }
    public static boolean checkBlock(String recipient,String blockNick){
        String sql = String.format("SELECT blacklist FROM BLACKLIST" +
                " WHERE BLACKLIST.nickname = '%s' AND BLACKLIST.blacklist = '%s'",recipient,blockNick);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname FROM USERS" +
                " WHERE login = '%s' AND password = '%s'", login, pass.hashCode());
        try {
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean nickIsBusy(String nick)  {
        String sql = String.format("SELECT nickname FROM USERS" +
                " WHERE USERS.nickname = '%s'",nick);
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
