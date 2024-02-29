import java.util.ArrayList;
import java.util.List;

public class Moving {

    public List<Point> moveUp(DecodingData decodingData) {
        List<Point> points = new ArrayList<>();
        int row = decodingData.getStartPoint().getRow();
        int column = decodingData.getStartPoint().getColumn();
        points.add(new Point(row, column));
        points.add(new Point(row, column - 1));
        points.add(new Point(row - 1, column));
        points.add(new Point(row - 1, column - 1));
        points.add(new Point(row - 2, column));
        points.add(new Point(row - 2, column - 1));
        points.add(new Point(row - 3, column));
        points.add(new Point(row - 3, column - 1));
        return points;
    }

    public List<Point> moveDown(DecodingData decodingData) {
        List<Point> points = new ArrayList<>();
        int row = decodingData.getStartPoint().getRow();
        int column = decodingData.getStartPoint().getColumn();
        points.add(new Point(row, column));
        points.add(new Point(row, column- 1));
        points.add(new Point(row + 1, column));
        points.add(new Point(row + 1, column - 1));
        points.add(new Point(row + 2, column));
        points.add(new Point(row + 2, column - 1));
        points.add(new Point(row + 3, column));
        points.add(new Point(row + 3, column - 1));
        return points;
    }

    public List<Point> moveClockwise(DecodingData decodingData) {
        List<Point> points = new ArrayList<>();
        int row = decodingData.getStartPoint().getRow();
        int column = decodingData.getStartPoint().getColumn();
        points.add(new Point(row, column));
        points.add(new Point(row, column - 1));
        points.add(new Point(row + 1, column));
        points.add(new Point(row + 1, column - 1));
        points.add(new Point(row + 1, column - 2));
        points.add(new Point(row + 1, column - 3));
        points.add(new Point(row, column - 2));
        points.add(new Point(row, column - 3));
        return points;
    }

    public List<Point> moveCounterclockwise(DecodingData decodingData) {
        List<Point> points = new ArrayList<>();
        int row = decodingData.getStartPoint().getRow();
        int column = decodingData.getStartPoint().getColumn();
        points.add(new Point(row, column));
        points.add(new Point(row, column - 1));
        points.add(new Point(row - 1, column));
        points.add(new Point(row - 1, column - 1));
        points.add(new Point(row - 1, column - 2));
        points.add(new Point(row - 1, column - 3));
        points.add(new Point(row, column - 2));
        points.add(new Point(row, column - 3));
        return points;
    }
}
