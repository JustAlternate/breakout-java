import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Board extends JPanel implements ActionListener, KeyListener {
  Timer time;
  Ball ball;
  Paddle paddle;
  ArrayList<Brick> bricks;

  public Board() {
    time = new Timer(10, this);
    setFocusable(true);
    addKeyListener(this);
    ball = new Ball(200, 300, new Geometry(25, 15));
    paddle = new Paddle(350, 950, new Geometry(100, 100));
    bricks = new ArrayList<Brick>();
    initializeBricks(8, 16, 75, 30);
    time.start();
  }

  private void initializeBricks(int rows, int collumns, int width, int height) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < collumns; j++) {
        bricks.add(
            new Brick(j * width, i * height, new Geometry(width, height)));
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Make the ball move.
    ball.move();
    // Make the ball collision to walls, paddle and bricks.
    ball.checkCollision();
    ball.checkCollision(paddle);
    ball.checkCollision(bricks);
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    ball.draw(g);
    paddle.draw(g);
    for (Brick brick : bricks) {
      brick.draw(g);
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      paddle.moveLeft();
    } else if (key == KeyEvent.VK_RIGHT) {
      paddle.moveRight();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }
}
