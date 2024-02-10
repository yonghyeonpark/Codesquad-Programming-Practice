import java.util.ArrayList;
import java.util.List;

public class Process {

    private static final String SPACE = " ";

    private int step;
    private final List<Desk> desks;

    public Process() {
        this.step = 1;
        this.desks = new ArrayList<>();
    }

    public void addDesk(Desk desk) {
        desks.add(desk);
    }

    public void move(int start, int to) {
        step++;
        desks.get(to - 1).put(desks.get(start - 1).draw());
    }

    public void print() {
        Desk desk1 = desks.get(0);
        Desk desk2 = desks.get(1);
        Desk desk3 = desks.get(2);

        StringBuilder sb = new StringBuilder();
        sb.append("Step ")
                .append(step)
                .append("\n");
        for (int i = 0; i < 9; i++) {
            sb.append(desk1.getResult().get(i))
                    .append(SPACE)
                    .append(desk2.getResult().get(i))
                    .append(SPACE)
                    .append(desk3.getResult().get(i))
                    .append(SPACE)
                    .append("\n");
        }
        sb.append(desk1.getName())
                .append(SPACE)
                .append(desk2.getName())
                .append(SPACE)
                .append(desk3.getName());
        System.out.println(sb);
    }

    public int getStep() {
        return step;
    }
}
