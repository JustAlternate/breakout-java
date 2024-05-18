import java.awt.*;

public class Geometry {
  int width, height;
  Rectangle rect;
  Color c;

  // Constuctor to make rectangle.
  public Geometry(int width, int height, Color c) {
    this.width = width;
    this.height = height;
    this.c = c;
    // Initialize x and y coordinate to 0.
    this.rect = new Rectangle(0, 0, width, height);
  }

  public void draw(Graphics2D g) {
    Color oldColor = g.getColor();
    g.setColor(Color.BLACK); // To set the border color to black
    int thickness = 10;
    Stroke oldStroke = g.getStroke();
    g.setStroke(new BasicStroke(thickness));
    g.drawRect(rect.x, rect.y, width, height);
    g.setStroke(oldStroke);
    g.setColor(c);
    g.fillRect(rect.x, rect.y, width, height);
    g.setColor(oldColor);
  }
}
