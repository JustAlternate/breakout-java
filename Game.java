public class Game {
  Window window;
  Board board;
  int score;
  int turn;

  public Game() {
    board = new Board();
    window = new Window(board);
  }

  public static void main(String[] args) {
    new Game();
  }
}
