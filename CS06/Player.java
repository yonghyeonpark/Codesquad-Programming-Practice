import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> location;
    private final String input;
    private int score;

    public Player(String input) {
        this.location = new ArrayList<>();
        this.input = input;
        this.score = 0;
        setUp();
    }

    private void setUp() {
        location.add("Z");
        location.add("W");
        location.add("0");
    }

    public void updateLocation(List<String> updatedLocation) {
        location.clear();
        location.addAll(updatedLocation);
    }

    public void addScore() {
        score += 1;
    }

    public List<String> getLocation() {
        return location;
    }

    public String getInput() {
        return input;
    }

    public int getScore() {
        return score;
    }
}
