import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
  public Window(Board board) {
    setTitle("JustAlternate's Breakout Game");
    setSize(Constant.width, Constant.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setBackground(Color.MAGENTA);
    add(board);
    setVisible(true);
  }
}
