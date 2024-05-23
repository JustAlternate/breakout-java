package src.visuals;

import java.awt.*;

public class Geometry {
  public Rectangle rect;
  public Color c;

  public Geometry(float width, float height, Color c) {
    this.c = c;

    // Initialize x and y coordinate to 0.
    this.rect = new Rectangle(0, 0, (int) width, (int) height);
  }

  public void draw(Graphics2D g) {
    Color oldColor = g.getColor();
    // Set border color of entity to black
    g.setColor(Color.BLACK);
    int thickness = 10;
    Stroke oldStroke = g.getStroke();
    g.setStroke(new BasicStroke(thickness));
    g.drawRect(rect.x, rect.y, rect.width, rect.height);
    g.setStroke(oldStroke);
    g.setColor(c);
    g.fillRect(rect.x, rect.y, rect.width, rect.height);
    g.setColor(oldColor);
  }
}
