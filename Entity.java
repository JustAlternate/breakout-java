import java.awt.*;

class Entity {
  Geometry geometry;

  public Entity(int x, int y, Geometry geometry) {
    this.geometry = geometry;
    geometry.rect.x = x;
    geometry.rect.y = y;
  }

  // TODO: find a proper way to destroy
  public void destroy() {
    geometry.rect.x = -100;
    geometry.rect.y = -100;
  }

  public void draw(Graphics g) {
    geometry.draw(g);
  }
}
