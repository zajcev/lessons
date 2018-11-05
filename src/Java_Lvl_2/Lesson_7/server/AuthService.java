package Java_Lvl_2.Lesson_7.server;

import java.sql.*;

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
    public static void addUsers(String login, String pass, String nick) throws SQLException {
        String sql = String.format("INSERT INTO USERS (login, password, nickname)" +
                "VALUES ('%s','%s','%s')", login, pass.hashCode(), nick);
        stmt.execute(sql);
    }

    public static void addBlock(String sender,String blockNick) throws SQLException {
        String sql = String.format("INSERT INTO BLACKLIST (nickname, blocklist)" +
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
                " WHERE login = '%s' AND password = '%s'", login, pass);
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


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
