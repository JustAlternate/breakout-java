import java.awt.*;
import java.util.ArrayList;

class Ball extends MovingEntity {
  public Ball(int x, int y, Geometry geometry) {
    super(x, y, geometry);
    dx = 1.0;
    dy = -0.5;
    speed = 1;
  }

  // We want to make the ball able to to bounce of of top, right
  // and left walls.
  public void checkCollision() {
    // TODO: find a way to make the window size accessible here.
    if (geometry.rect.x <= 0 || geometry.rect.x + geometry.width >= 1200) {
      dx = -dx;
    }
    if (geometry.rect.y + geometry.height <= 0) {
      dy = -dy;
    }
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
        brick.destroy();
        break;
      }
    }
  }

  public void changeDirection(Rectangle collidedObjectRect) {
    // Calculate the center of the ball and the brick
    int ballCenterX = geometry.rect.x + geometry.width / 2;
    int ballCenterY = geometry.rect.y + geometry.height / 2;
    int collidedObjectCenterX = collidedObjectRect.x + collidedObjectRect.width / 2;
    int collidedObjectCenterY = collidedObjectRect.y + collidedObjectRect.height / 2;

    int deltaX = ballCenterX - collidedObjectCenterX;
    int deltaY = ballCenterY - collidedObjectCenterY;

    // Change direction of the ball corresponding to the newly calculated projected
    // vector
    dx = Math.signum(deltaX);
    dy = Math.signum(deltaY);

  }
}
