import java.awt.*;
import java.util.ArrayList;

class Ball extends MovingEntity {
  public Ball(int x, int y, Geometry geometry) {
    super(x, y, geometry);
    dx = 1.0;
    dy = -0.5;
    speed = 5;
  }

  // We want to make the ball able to to bounce of of top, right
  // and left walls.
  public void checkCollision() {
    if (geometry.rect.x <= 0 || geometry.rect.x + geometry.width >= Constant.width) {
      dx = -dx;
    }
    if (geometry.rect.y + geometry.height <= 0) {
      dy = -dy;
    }
  }

  public boolean checkDeath() {
    return geometry.rect.y + geometry.height > Constant.height;
  }

  public void checkCollision(Paddle paddle) {
    if (paddle.geometry.rect.intersects(this.geometry.rect)) {
      // If it collide with the paddle we change the ball direction
      changeDirection(paddle.geometry.rect);
    }
  }

  public void checkCollision(ArrayList<Brick> bricks) {
    for (Brick brick : bricks) {
      if (brick.geometry.rect.intersects(this.geometry.rect)) {
        // If it collide with a brick we change the ball direction.
        changeDirection(brick.geometry.rect);
        // And we remove the brick collided from the bricks ArrayList
        bricks.remove(brick);
        break;
      }
    }
  }

  public void changeDirection(Rectangle collidedObjectRect) {
    // Calculate the center of the ball and the brick
    double ballCenterX = geometry.rect.getCenterX();
    double ballCenterY = geometry.rect.getCenterY();
    double collidedObjectCenterX = collidedObjectRect.getCenterX();
    double collidedObjectCenterY = collidedObjectRect.getCenterY();

    double deltaX = ballCenterX - collidedObjectCenterX;
    double deltaY = ballCenterY - collidedObjectCenterY;

    // Change direction of the ball corresponding to the newly calculated vector.
    dx = Math.signum(deltaX);
    dy = Math.signum(deltaY);

  }
}
