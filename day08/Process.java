import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Process {

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

        String step = "Step " + this.step + "\n";
        StringJoiner result = new StringJoiner(" ", "", "");
        for (int i = 0; i < 9; i++) {
            result.add(desk1.getResult().get(i))
                    .add(desk2.getResult().get(i))
                    .add(desk3.getResult().get(i))
                    .add("\n");
        }
        result.add(desk1.getName())
                .add(desk2.getName())
                .add(desk3.getName());

        System.out.print(step + result);
    }

    public int getStep() {
        return step;
    }
}
