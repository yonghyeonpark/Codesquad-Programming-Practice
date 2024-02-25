import java.util.List;

public class Polygon implements Figure {

    private final List<Coordinate> coordinates;

    public Polygon(List<Coordinate> coordinates) {
        validateCoordinatesSize(coordinates);
        this.coordinates = coordinates;
    }

    private void validateCoordinatesSize(List<Coordinate> coordinates) {
        if (coordinates.size() < 4) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    @Override
    public double calculate() {
        // 좌표가 정렬되어 있다고 가정 => 신발끈 공식
        // 정렬하기 위해 bfs? => 거리 순으로 하면 반례 존재
        return 0;
    }

    @Override
    public void printValue() {
    }
}
