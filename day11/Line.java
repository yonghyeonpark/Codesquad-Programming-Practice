import java.util.List;

public class Line implements Figure {

    private final List<Coordinate> coordinates;
    private double length;

    public Line(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double calculate() {
        Coordinate coordinate1 = coordinates.get(0);
        Coordinate coordinate2 = coordinates.get(1);
        int deltaX = coordinate1.getX() - coordinate2.getX();
        int deltaY = coordinate1.getY() - coordinate2.getY();

        length = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return length;
    }

    @Override
    public void printValue() {
        System.out.println("두 점 사이 거리는 " + length + "입니다.");
    }
}
