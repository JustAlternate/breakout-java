class Paddle extends MovingEntity {
  public Paddle(int x, int y, Geometry geometry) {
    super(x, y, geometry);
    speed = 50;
  }

  public void moveLeft() {
    if (geometry.rect.x > 0) {
      dx = -1;
      move();
    }
  }

  public void moveRight() {
    if (geometry.rect.x + geometry.width < Constant.width) {
      dx = 1;
      move();
    }
  }
}
