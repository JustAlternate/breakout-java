import java.awt.*;

public class Geometry {
  int width, height;
  Rectangle rect;
  Color c;

  // Constuctor to make rectangle.
  public Geometry(int width, int height) {
    this.width = width;
    this.height = height;
    this.rect = new Rectangle(0, 0, width, height);
  }

  public void draw(Graphics g) {
    g.fillRect(rect.x, rect.y, width, height);
  }
}
