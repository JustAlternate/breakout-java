package src.entities;

import java.awt.Color;
import java.util.List;

import src.visuals.Geometry;
import src.main.*;
import src.utils.*;

public class Ball extends Entity implements MovingEntity {
  protected float speed;
  protected int collided;
  protected double dx;
  protected double dy;

  // In classic arcade breakout the ball can destroy only one brick at a time
  // between each paddle or wall collisions.
  protected boolean desactivate;

  public Ball(int x, int y, Geometry geometry, float speed, double dx, double dy) {
    super(x, y, geometry);
    this.speed = speed;
    this.dx = dx;
    this.dy = dy;
  }

  // We want to make the ball able to to bounce of of top, right
  // and left walls.
  public void checkCollision() {
    // Ball collided left or right wall
    if (geometry.rect.x <= 0 || geometry.rect.x + geometry.rect.width >= Constant.WIDTH) {
      desactivate = false;
      dx = -dx;
    }

    // Ball collided roof
    if (geometry.rect.y + geometry.rect.height <= 0) {
      Board.scalePaddle(0.5f);
      desactivate = false;
      dy = -dy;
    }
  }

  public void checkCollision(Paddle paddle) {
    if (paddle.geometry.rect.intersects(this.geometry.rect)) {
      // If it collide with the paddle we change the ball direction
      changeDirection(paddle);

      desactivate = false;
    }
  }

  public void checkCollision(List<Brick> bricks) {
    if (!desactivate) {
      for (Brick brick : bricks) {
        if (brick.geometry.rect.intersects(this.geometry.rect)) {
          desactivate = true;

          // Update score with the points the brick made.
          Game.score += Game.colorToPoints.get(brick.geometry.c);
          collided++;
          if (collided == 4 || collided == 12) {
            speed++;
          }
          if (brick.geometry.c == Color.ORANGE || brick.geometry.c == Color.RED) {
            speed += 0.2f;
          }

          // If it collide with a brick we change the ball direction.
          changeDirection(brick);

          bricks.remove(brick);
          break;
        }
      }
    }
  }

  public void changeDirection(Paddle collidedObject) {
    // Calculate the center of the ball and the brick
    double ballCenterX = geometry.rect.getCenterX();
    double collidedObjectCenterX = collidedObject.geometry.rect.getCenterX();
    double deltaX = ballCenterX - collidedObjectCenterX;
    // Push the ball to the right if it touches the right part of the paddle.
    dx = Math.signum(deltaX);
    dy = -dy;
  }

  private void changeDirection(Brick collidedObject) {
    dy = -dy;
  }

  public void move() {
    geometry.rect.x += dx * speed;
    geometry.rect.y += dy * speed;
  }
}
