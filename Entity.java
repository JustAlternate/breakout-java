import java.awt.*;

class Entity {
  Geometry geometry;

  public Entity(int x, int y, Geometry geometry) {
    this.geometry = geometry;
    geometry.rect.x = x;
    geometry.rect.y = y;
  }

  public void draw(Graphics2D g) {
    geometry.draw(g);
  }
}
