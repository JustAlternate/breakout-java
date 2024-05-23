package src.entities;

import java.awt.*;
import src.visuals.Geometry;

public class Entity {
  public Geometry geometry;

  public Entity(int x, int y, Geometry geometry) {
    this.geometry = geometry;
    geometry.rect.x = x;
    geometry.rect.y = y;
  }

  public void draw(Graphics2D g) {
    geometry.draw(g);
  }
}
