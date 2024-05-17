import javax.swing.*;

class Window extends JFrame {
  public Window(Board board) {
    setTitle("JustAlternate's Breakout Game");
    setSize(Constant.width, Constant.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    add(board);
    setVisible(true);
  }
}
