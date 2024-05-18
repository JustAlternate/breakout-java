import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Board extends JPanel implements ActionListener, KeyListener {
  Timer time;
  Ball ball;
  Paddle paddle;
  ArrayList<Brick> bricks;

  int turn = 1;
  int screen = 1;
  int score = 0;

  public Board() {
    time = new Timer(10, this);
    setFocusable(true);
    addKeyListener(this);
    ball = spawnBall();
    paddle = new Paddle(350, 950, new Geometry(70, 20, Color.CYAN));
    bricks = new ArrayList<Brick>();
    initializeBricks();
    setBackground(Color.BLACK);
    time.start();
  }

  private Ball spawnBall() {
    return new Ball(200, 300, new Geometry(25, 15, Color.WHITE));
  }

  private void initializeBricks() {
    Color[] Colors = {
        Color.RED,
        Color.ORANGE,
        Color.GREEN,
        Color.YELLOW,
    };

    for (int i = 0; i < 8; i++) {
      Color c = Colors[i / 2];
      for (int j = 0; j < 16; j++) {
        bricks.add(
            new Brick(5 + j * (65 + 10), 120 + i * (20 + 10), new Geometry(65, 20, c)));
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
    if (ball.checkDeath()) {
      LostBall();
    }

    System.out.println(bricks.size());
    if (bricks.size() == 0 && screen < 2) {
      initializeBricks();
      spawnBall();
      screen++;
    }

    repaint();
  }

  private void LostBall() {
    if (turn < 300) {
      turn++;
      ball = spawnBall();
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    ball.draw(g2);
    paddle.draw(g2);
    for (Brick brick : bricks) {
      brick.draw(g2);
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
