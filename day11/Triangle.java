import java.util.List;

public class Triangle implements Figure {

    private final List<Coordinate> coordinates;
    private double area;

    public Triangle(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double calculate() {
        double line1 = new Line(List.of(coordinates.get(0), coordinates.get(1))).calculate();
        double line2 = new Line(List.of(coordinates.get(1), coordinates.get(2))).calculate();
        double line3 = new Line(List.of(coordinates.get(0), coordinates.get(2))).calculate();
        double s = (line1 + line2 + line3) / 2;
        area = Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));
        return area;
    }

    @Override
    public void printValue() {
        System.out.println("삼각형 넓이는 " + area + "입니다.");
    }
}
