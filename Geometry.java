import java.awt.*;

public class Geometry {
  int width, height;
  Shape shape;

  Rectangle rect;

  public enum Shape {
    CIRCLE, RECTANGLE
  }

  public Geometry(int size, Shape shape) {
    this.width = size;
    this.height = size;
    this.shape = shape;
    this.rect = new Rectangle(0, 0, size, size);
  }

  public Geometry(int width, int height, Shape shape) {
    this.width = width;
    this.height = height;
    this.shape = shape;
    this.rect = new Rectangle(0, 0, width, height);
  }

  public void draw(Graphics g) {
    if (shape == Shape.CIRCLE) {
      g.fillOval(rect.x, rect.y, width, height);
    } else if (shape == Shape.RECTANGLE) {
      g.fillRect(rect.x, rect.y, width, height);
    }
  }
}
