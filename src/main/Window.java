package src.main;

import javax.swing.JFrame;
import java.awt.Color;
import src.utils.Constant;

class Window extends JFrame {
  Window(Board board) {
    setTitle("JustAlternate's Breakout Game");
    setSize(Constant.WIDTH, Constant.HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setBackground(Color.MAGENTA);
    add(board);
    setVisible(true);
  }
}
