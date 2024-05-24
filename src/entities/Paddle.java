package src.entities;

import src.visuals.Geometry;

public class Paddle extends Entity {
  public Paddle(int x, int y, Geometry geometry) {
    super(x, y, geometry);
  }

  public void Scale(float f) {
    geometry.rect.width = (int) (geometry.rect.width * f);
  }
}
