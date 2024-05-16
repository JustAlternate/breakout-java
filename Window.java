import javax.swing.*;

class Window extends JFrame {
  public int width = 1200;
  public int height = 1000;

  public Window(Board board) {
    setTitle("JustAlternate's Breakout Game");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    add(board);
    setVisible(true);
  }
}
