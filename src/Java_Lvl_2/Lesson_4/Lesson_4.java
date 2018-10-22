package Java_Lvl_2.Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Lesson_4  {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.setVisible(true);
    }
}

class MyWindow extends JFrame {

    private JTextArea chat;
    private JTextField msg;
    private JButton send;

    public MyWindow() {

        setBounds(500, 500, 500, 500);
        setTitle("Chat Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chat = new JTextArea(); // Поле для текста
        chat.setEditable(false); // нельзя в нём писать
        chat.setLineWrap(true); // автоперенос строки

        JScrollPane jScrollPane = new JScrollPane(chat); // что бы можно было пролистать чат (если много сообщений)
        add(jScrollPane);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel, BorderLayout.PAGE_END); // панель с кнопкой и сообщением в конец страницы

        msg = new JTextField(); // строка для ввода
        send = new JButton("Отправить");
        panel.add(send, BorderLayout.LINE_END); // кнопка в конце строки
        panel.add(msg, BorderLayout.CENTER); // строка для сообщения по центру панели

        msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             sendMsg();
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sendMsg();
            }
        });

    }
    public void sendMsg(){
      String message = msg.getText();
      if (msg.getText().length() != 0) { // если пустое сообщение не выводить
          chat.append(message + "\n");
          msg.setText(""); // после отправки отчистить поле с сообщением
      }
    }
}
