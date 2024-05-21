import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

class Board extends JPanel implements ActionListener, MouseMotionListener {
  Timer time;
  static Ball ball;
  Paddle paddle;
  List<Brick> bricks;

  Label labelScore;
  Label labelDummyScore2;
  Label labelScreen;
  Label labelBallUsed;

  static int ballUsed = 1;
  static int screen = 1;
  static int score = 0;

  public Board() {
    time = new Timer(10, this);
    setFocusable(true);
    setLayout(null);
    addMouseMotionListener(this);
    ball = spawnBall();
    paddle = new Paddle(350, 950, new Geometry(70, 20, Color.CYAN));
    bricks = new ArrayList<Brick>();

    labelScreen = new Label("1", 100, Color.WHITE, 50, 10, 100, 100);

    labelScore = new Label("000", 100, Color.WHITE, 100, 110, 300, 100);
    labelBallUsed = new Label("1", 100, Color.WHITE, 700, 10, 100, 100);

    // This label is useless it's just here to recreate the original Arcade breakout
    // 2nd player score
    labelDummyScore2 = new Label("000", 100, Color.WHITE, 750, 110, 300, 100);

    add(labelScore);
    add(labelScreen);
    add(labelBallUsed);
    add(labelDummyScore2);

    initializeBricks();
    setBackground(Color.BLACK);
    time.start();
  }

  static public Ball spawnBall() {
    return new Ball(200, 500, new Geometry(25, 15, Color.WHITE), 3f, 1d, 1d);
  }

  static public void LostBall() {
    if (ballUsed < 3) {
      ballUsed++;
      ball = spawnBall();
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
    initializeBricks();
    spawnBall();
    score = 0;
    ballUsed = 1;
    screen++;
    labelScreen.setText(String.format("%d", screen));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ball.move();

    // Make the ball collision to walls, paddle and bricks.
    ball.checkCollision();
    ball.checkCollision(paddle);
    ball.checkCollision(bricks);

    ball.checkDeath();

    if (bricks.size() == 0 && screen < 2) {
      resetBoard();
    }
    repaint();

    // Update game labels
    labelScore.setText(String.format("%03d", score));
    labelBallUsed.setText(String.format("%d", ballUsed));
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
    paddle.geometry.rect.x = mouseX - paddle.geometry.width / 2;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }
}
