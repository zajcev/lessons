package Java_Lvl_2.Lesson_7.client;

import Java_Lvl_2.Lesson_7.server.MainServer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button btn1;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Hyperlink registration;

    @FXML
    ListView<String> clientsList;

    @FXML
    HBox regPane;

    @FXML
    TextField regLog;

    @FXML
    PasswordField regPass;

    @FXML
    TextField regNick;

    @FXML
    Hyperlink back;

    Socket socket;

    DataInputStream in;
    DataOutputStream out;


    private boolean isAuthorized;


    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void setAthorized(boolean isAuthorized){
        this.isAuthorized = isAuthorized;

        if(!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientsList.setVisible(false);
            clientsList.setManaged(false);
            registration.setVisible(true);
            registration.setManaged(true);
            regPane.setVisible(false);
            regPane.setManaged(false);
            back.setVisible(false);
            back.setManaged(false);

        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientsList.setVisible(true);
            clientsList.setManaged(true);
            registration.setVisible(false);
            registration.setManaged(false);

        }
    }
   public void viewRegPane(){
          regPane.setVisible(true);
          regPane.setManaged(true);
          upperPanel.setVisible(false);
          upperPanel.setManaged(false);
          registration.setVisible(false);
          registration.setManaged(false);
          back.setVisible(true);
          back.setManaged(true);
    }

public void backToAuth(){ setAthorized(false);}



    public void connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // цикл для авторизации
                        while (true) {
                            String str = in.readUTF();
                            if(str.startsWith("/authok")) {
                                setAthorized(true);
                                textArea.clear();
                                break;
                            } else {
                                textArea.appendText(str + "\n");
                            }
                            if (str.startsWith("Вы зарегистрированы")){
                                backToAuth();
                                textArea.clear();
                                textArea.appendText(str+"\n");
                            }

                        }
                        // цикл для работы
                        while (true) {
                            String str = in.readUTF();
                            if(str.startsWith("/")){
                                if (str.equals("/serverClosed")) {
                                    setAthorized(false);
                                    break;
                                }
                                if(str.startsWith("/clientlist")) {
                                    String[] tokens = str.split(" ");
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            clientsList.getItems().clear();
                                            for (int i = 1; i < tokens.length; i++) {
                                                clientsList.getItems().add(tokens[i]);
                                            }
                                        }
                                    });
                                }
                            } else {
                                textArea.appendText(str + "\n");
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void tryToAuth(ActionEvent actionEvent) {
        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToReg(){
        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/reg " + regLog.getText() + " " + regPass.getText() + " " + regNick.getText());
            regLog.clear();
            regPass.clear();
            regNick.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
