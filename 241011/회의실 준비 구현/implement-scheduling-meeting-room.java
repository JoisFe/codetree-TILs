import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<DisscussionTime> disscussionTimes = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            disscussionTimes.add(new DisscussionTime(sc.nextInt(), sc.nextInt()));
        }

        disscussionTimes = disscussionTimes.stream().sorted().collect(Collectors.toList());

        int cnt = 0;
        int endTime = 0;

        for (int i = 0; i < n; ++i) {
            if (endTime <= disscussionTimes.get(i).getStartTime()) {
                endTime = disscussionTimes.get(i).getEndTime();
                ++cnt;
            }
        }

        System.out.println(cnt);
    }
}

class DisscussionTime implements Comparable<DisscussionTime> {
    private final int startTime;
    private final int endTime;

    public DisscussionTime (int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int compareTo(DisscussionTime other) {
        return Integer.compare(this.endTime, other.endTime);
    }
}