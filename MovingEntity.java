class MovingEntity extends Entity {
  double dx;
  double dy;
  int speed;

  public MovingEntity(int x, int y, Geometry geometry) {
    super(x, y, geometry);
    dx = 0;
    dy = 0;
  }

  public void move() {
    geometry.rect.x += dx * speed;
    geometry.rect.y += dy * speed;
  }
}
