// Paddle doesnt implement MovingEntity because it has a special way of moving using mouse event.
class Paddle extends Entity {
  public Paddle(int x, int y, Geometry geometry) {
    super(x, y, geometry);
  }
}
