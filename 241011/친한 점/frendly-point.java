import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Coordinate> coordinateSet = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            coordinateSet.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < m; ++i) {
            System.out.println(Optional.ofNullable(coordinateSet.ceiling(new Coordinate(sc.nextInt(), sc.nextInt()))).orElse(new Coordinate(-1, -1)));
        }
    }
}

class Coordinate implements Comparable<Coordinate> {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        } else {
            return Integer.compare(this.x, other.x);
        }
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}