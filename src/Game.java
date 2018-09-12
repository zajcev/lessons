/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

/**
 * @author Михаил Зайцев
 */
public class Game extends JFrame {
    /**
     * @param border - массив с числами
     * @param button - массив обьектов типа кнопка
     */
    int[][] border = {{0, 1, 2, 3},
                      {4, 5, 6, 7},
                      {8, 9, 10, 11},
                      {12, 13, 14, 15}};
    JButton[][] button = new JButton[4][4];
    JPanel panel = new JPanel(new GridLayout(4,4));

    public Game() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 300, 300);
        setResizable(false);


        Container container = getContentPane();
        container.add(panel);

        menu();

        reroll(border);
        display();
    }

    /**
     * Метод для того что бы поменять местами 0 и число
     * @param num - число с нажатой снопки
     */
    public void change(int num) {
        int row = 0;
        int col = 0;
        for(int i = 0; i < 4;i++){
            for (int j = 0; j < 4; j++) {
                if (border[i][j] == num){
                    row = i;
                    col = j;
                }
            }
        }
        if (col < 3)
        if (border[row][col + 1] == 0) {
         border[row][col + 1] = border[row][col];
         border[row][col] = 0;
        }
        if(col > 0)
            if (border[row][col - 1] == 0) {
         border[row][col - 1] = border[row][col];
         border[row][col] = 0;
        }
        if(row < 3)
            if (border[row + 1][col] == 0) {
        border[row + 1][col] = border[row][col];
         border[row][col] = 0;
        }
        if(row > 0)
            if (border[row - 1][col] == 0) {
         border[row - 1][col] = border[row][col];
         border[row][col] = 0;
        }
        display();
}

    /**
     * Метод для перемешивания чисел в массиве
     * @param arr - массив border
     * @return - перемешанный рандомно массив border
     */
    public int[][] reroll(int arr[][]) {
        int f;
        int s;
        int temp;
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            f = rand.nextInt(4);
            s = rand.nextInt(4);
            for (int j = 0; j < 4; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[f][s];
                arr[f][s] = temp;
            }
        }
        return arr;
    }

    /**
     * Метод для отчистки и вывода кнопок на панель
     */
    public void display() {
        panel.removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                button[i][j] = new JButton("" + border[i][j]);
                if (border[i][j] == 0) {
                    button[i][j] = new JButton("" + border[i][j]);
                    button[i][j].setVisible(false);
                }
                panel.add(button[i][j]);
                button[i][j].addActionListener(new Check());
            }
        }
        panel.validate();
        panel.repaint();
    }

    /**
     * Добавление меню
     */
    public void menu(){
        JMenuBar bar = new JMenuBar();
        JMenu menu  = new JMenu("Меню");

        JMenuItem exit = new JMenuItem("Выход");
        JMenuItem reroll = new JMenuItem("Заново");

        exit.addActionListener(new Check());
        reroll.addActionListener(new Check());

        menu.add(reroll);
        menu.add(exit);
        bar.add(menu);
        setJMenuBar(bar);

}
    /**
     * При нажатии кнопки берёт число с название кнопки и переводит его из String в int.
     * Далее вызывается метод change для смены кнопки 0 и нажатой местами
     */
    private class Check implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          if(e.getActionCommand().equals("Выход")){
              System.exit(0);
          }
          if(e.getActionCommand().equals("Заново")){
           reroll(border);
           display();
          }else{
              int num = Integer.parseInt(e.getActionCommand());
              change(num);
          }
        }
    }

        public static void main(String[] args) {

        Game game = new Game();
        game.setVisible(true);

        }


}

