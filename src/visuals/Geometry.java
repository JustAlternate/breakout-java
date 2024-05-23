package src.visuals;

import java.awt.*;

public class Geometry {
  public float width;
  public float height;
  public Rectangle rect;
  public Color c;

  public Geometry(float width, float height, Color c) {
    this.width = width;
    this.height = height;
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
    g.drawRect(rect.x, rect.y, (int) width, (int) height);
    g.setStroke(oldStroke);
    g.setColor(c);
    g.fillRect(rect.x, rect.y, (int) width, (int) height);
    g.setColor(oldColor);
  }
}
