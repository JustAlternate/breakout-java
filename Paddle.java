class Paddle extends MovingEntity {
  public Paddle(int x, int y, Geometry geometry) {
    super(x, y, geometry);
    speed = 8;
  }

  public void moveLeft() {
    if (geometry.rect.x > 0) {
      dx = -1;
      move();
    }
  }

  // TODO: find a way to make the window size accessible here.
  public void moveRight() {
    if (geometry.rect.x + geometry.width < 1200) {
      dx = 1;
      move();
    }
  }
}
