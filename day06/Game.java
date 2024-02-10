import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final Map<String, String> route;
    private final Map<String, String> shortcut;

    public Game() {
        this.route = new HashMap<>();
        this.shortcut = new HashMap<>();
        setUp();
    }

    private void setUp() {
        route.put("Z", "W");
        route.put("W", "X");
        route.put("X", "Y");
        route.put("Y", "Z");
        route.put("V", "Y");

        shortcut.put("W", "V");
        shortcut.put("X", "V");
        shortcut.put("V", "Z");
    }

    public void move(Player player, List<Integer> throwing) {
        // 윷을 던진 횟수만큼 반복
        for (int movingCount : throwing) {
            player.updateLocation(getNextLocation(player, movingCount));
        }
    }

    /**
     * 분기 설정
     * 1. 도착점이 V일 때
     * 2. 시작점이 V일 때 (도착점이 Z일 때, 점수 얻는 조건 추가)
     * 3. 나머지 경우 (도착점이 Z일 때, 점수 얻는 조건 추가)
     */
    private List<String> getNextLocation(Player player, int movingCount) {
        // 초기 설정한 위치
        List<String> locationOfHorse = player.getLocation();
        String startingPoint = locationOfHorse.get(0);
        String destination = locationOfHorse.get(1);
        int location = Integer.parseInt(locationOfHorse.get(2));

        String nextStartingPoint = "";
        String nextDestination = "";
        int nextLocation = 0;

        List<String> nextLocationOfHorse = new ArrayList<>();
        // 도착 지점이 V일 때
        int movingResult = location + movingCount;
        if (destination.equals("V")) {
            if (movingResult == 3) {
                nextStartingPoint = destination;
                nextDestination = shortcut.get(nextStartingPoint);
                nextLocation = 0;
            }
            if (movingResult < 3) {
                nextStartingPoint = startingPoint;
                nextDestination = destination;
                nextLocation = movingResult;
            }
            if (movingResult > 3 && movingResult < 6) {
                nextStartingPoint = destination;
                nextDestination = route.get(nextStartingPoint);
                nextLocation = movingCount - (3 - location);
            }
            if (movingResult >= 6) {
                nextStartingPoint = route.get(destination);
                nextDestination = route.get(nextStartingPoint);
                nextLocation = movingCount - (6 - location);
            }
            nextLocationOfHorse.add(nextStartingPoint);
            nextLocationOfHorse.add(nextDestination);
            nextLocationOfHorse.add(String.valueOf(nextLocation));
            return nextLocationOfHorse;
        }

        // 출발 지점이 V일 때
        if (startingPoint.equals("V")) {
            if (movingResult < 3) {
                nextStartingPoint = startingPoint;
                nextDestination = destination;
                nextLocation = movingResult;
            }
            if (movingResult >= 3) {
                nextStartingPoint = destination;
                nextDestination = route.get(nextStartingPoint);
                nextLocation = movingCount - (3 - location);
                player.addScore();
            }
            nextLocationOfHorse.add(nextStartingPoint);
            nextLocationOfHorse.add(nextDestination);
            nextLocationOfHorse.add(String.valueOf(nextLocation));
            return nextLocationOfHorse;
        }

        // 나머지
        if (movingResult == 5) {
            nextStartingPoint = destination;
            if (nextStartingPoint.equals("Z")) {
                nextDestination = route.get(nextStartingPoint);
                player.addScore();
            } else {
                nextDestination = shortcut.get(nextStartingPoint);
            }
            nextLocation = 0;
        }
        if (movingResult < 5) {
            nextStartingPoint = startingPoint;
            nextDestination = destination;
            nextLocation = movingResult;
        }
        if (movingResult > 5) {
            nextStartingPoint = destination;
            if (nextStartingPoint.equals("Z")) {
                player.addScore();
            }
            nextDestination = route.get(nextStartingPoint);
            nextLocation = movingCount - (5 - location);
        }
        nextLocationOfHorse.add(nextStartingPoint);
        nextLocationOfHorse.add(nextDestination);
        nextLocationOfHorse.add(String.valueOf(nextLocation));
        return nextLocationOfHorse;
    }
}