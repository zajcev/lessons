/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author user
 */
class Game extends JFrame {

    int[][] border = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
    JButton[][] button = new JButton[4][4];

    public Game() {
        reroll(border);

        setLayout(new GridLayout(4, 4));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 300, 300);
        setResizable(false);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                button[i][j] = new JButton("" + border[i][j]);
                if (border[i][j] == 0) {
                    button[i][j] = new JButton("" + border[i][j]);
                    button[i][j].setVisible(false);
                }
                add(button[i][j]);
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
            }
        }
    }

//    public void actionPerformed(int row, int col) {
//        if (border[row][col + 1] == 0 && col != 3) {
//         button[row][col + 1] = button[row][col];
//         button[row][col] = new JButton("" + 0);
//        } else if (border[row][col - 1] == 0 && col != 0) {
//         button[row][col - 1] = button[row][col];
//         button[row][col] = new JButton("" + 0);
//        } else if (border[row + 1][col] == 0 && row != 3) {
//        button[row + 1][col] = button[row][col];
//         button[row][col] = new JButton("" + 0);
//        } else if (border[row - 1][col] == 0 && row != 0) {
//         button[row - 1][col] = button[row][col];
//         button[row][col] = new JButton("" + 0);
//        }
//}

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
}

public class App {

    public static void main(String args[]) {

        Game game = new Game();
        game.setVisible(true);

    }
}
