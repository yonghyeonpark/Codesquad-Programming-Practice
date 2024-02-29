public class DecodingData {

    private final Point startPoint;
    private final Direction direction;

    public DecodingData(Point startPoint, Direction direction) {
        this.startPoint = startPoint;
        this.direction = direction;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Direction getDirection() {
        return direction;
    }
}
