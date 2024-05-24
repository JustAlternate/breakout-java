package src.entities;

import java.awt.*;
import src.visuals.Geometry;

/* We want this class to be abstract because we do not want people to instanciate raw Entity
 * and for other reasons I found there :
 * https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 */
public abstract class Entity {
  public Geometry geometry;

  Entity(int x, int y, Geometry geometry) {
    this.geometry = geometry;
    geometry.rect.x = x;
    geometry.rect.y = y;
  }

  /*
   * This method should not be abstract because we want it to be the same for
   * every entity.
   */
  public void draw(Graphics2D g) {
    geometry.draw(g);
  }
}
