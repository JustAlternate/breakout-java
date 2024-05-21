import java.util.*;
import java.awt.Color;

public class Game {
  Window window;
  Board board;

  // Create a hashmap to link each color to points gained.
  public static final Map<Color, Integer> colorToPoints = new HashMap<Color, Integer>();
  static {
    colorToPoints.put(Color.YELLOW, 1);
    colorToPoints.put(Color.GREEN, 3);
    colorToPoints.put(Color.ORANGE, 5);
    colorToPoints.put(Color.RED, 7);
  }

  public Game() {
    board = new Board();
    window = new Window(board);
  }

  public static void main(String[] args) {
    new Game();
  }
}
