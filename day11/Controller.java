import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final List<Coordinate> coordinates;

    public Controller(InputView inputView) {
        this.inputView = inputView;
        this.coordinates = new ArrayList<>();
    }

    public void run() {
        while (true) {
            try {
                String[] input = inputView.readCoordinates();

                // 유효성 검사를 위한 임시 저장소
                List<Coordinate> tem = new ArrayList<>();
                for (String nonFormatCoordinate : input) {
                    Coordinate coordinate = new Coordinate(nonFormatCoordinate);
                    tem.add(coordinate);
                }
                coordinates.addAll(tem);

                // (10,10)-(14,15)
                if (coordinates.size() == 2) {
                    process(new Line(coordinates));
                }
                //(10,10)-(14,15)-(20,8)
                if (coordinates.size() == 3) {
                    process(new Triangle(coordinates));
                }
                if (coordinates.size() >= 4) {
                    process(new Polygon(coordinates));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void process(Figure figure) {
        figure.calculate();
        figure.printValue();
    }
}
