package src.main;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

import src.entities.*;
import src.utils.*;
import src.visuals.Label;
import src.visuals.Geometry;

public class Board extends JPanel implements ActionListener, MouseMotionListener {
  private Timer time;
  Ball ball;
  static Paddle paddle;
  List<Brick> bricks;

  Label labelScore;
  Label labelDummyScore2;
  Label labelScreen;
  Label labelBallUsed;

  public Board() {
    setFocusable(true);
    setLayout(null);
    addMouseMotionListener(this);

    time = new Timer(10, this);
    ball = recreateBall();
    paddle = new Paddle(350, 950, new Geometry(70, 20, Color.CYAN));
    bricks = new ArrayList<Brick>();

    labelScreen = new Label("1", 100, Color.WHITE, 50, 10, 100, 100);
    labelScore = new Label("000", 100, Color.WHITE, 100, 110, 300, 100);
    labelBallUsed = new Label("1", 100, Color.WHITE, 700, 10, 100, 100);

    // This label is useless it's just here to recreate the original Arcade breakout
    // 2nd player score.
    labelDummyScore2 = new Label("000", 100, Color.WHITE, 750, 110, 300, 100);

    add(labelScore);
    add(labelScreen);
    add(labelBallUsed);
    add(labelDummyScore2);

    initializeBricks();
    setBackground(Color.BLACK);
    time.start();
  }

  public static void scalePaddle(float factor) {
    paddle.geometry.width = paddle.geometry.width * factor;
  }

  public Ball recreateBall() {
    Game.ballUsed++;
    return new Ball(200, 500, new Geometry(25, 15, Color.WHITE), 3f, 1d, 1d);
  }

  private void checkBallDeath() {
    if (ball.geometry.rect.y + ball.geometry.height > Constant.HEIGHT && Game.ballUsed < 3) {
      // We recreate a new ball.
      ball = recreateBall();
    }
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
            new Brick(2 + j * (70 + 5), 200 + i * (20 + 5), new Geometry(70, 20, c)));
      }
    }
  }

  public void resetBoard() {
    // We Update variables.
    Game.score = 0;
    Game.ballUsed = 0;
    Game.screen++;
    labelScreen.setText(String.format("%d", Game.screen));

    // And regenerate bricks and ball.
    initializeBricks();
    recreateBall();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    checkBallDeath();

    ball.move();
    // Make the ball collision to walls, paddle and bricks.
    ball.checkCollision();
    ball.checkCollision(paddle);
    ball.checkCollision(bricks);

    if (bricks.size() == 0 && Game.screen < 2) {
      resetBoard();
    }

    // Update game labels
    labelScore.setText(String.format("%03d", Game.score));
    labelBallUsed.setText(String.format("%d", Game.ballUsed));

    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    for (Brick brick : bricks) {
      brick.draw(g2);
    }

    paddle.draw(g2);
    ball.draw(g2);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int mouseX = e.getX();
    paddle.geometry.rect.x = mouseX - (int) paddle.geometry.width / 2;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }
}
