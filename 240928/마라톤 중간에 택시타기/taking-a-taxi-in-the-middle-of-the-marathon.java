import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Coordinate[] coordinates = new Coordinate[n];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(y, x);
        }

        int[] lDist = new int[n];
        int[] rDist = new int[n];

        for (int i = 1; i < n; ++i) {
            lDist[i] = lDist[i - 1] + getDistance(i - 1, i, coordinates);
        }

        for (int i = n - 2; i >= 0; --i) {
            rDist[i] = rDist[i + 1] + getDistance(i, i + 1, coordinates);
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; ++i) {
            minDistance = Math.min(minDistance, lDist[i - 1] + rDist[i + 1] + getDistance(i -1, i + 1, coordinates));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(minDistance));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static int getDistance(int idx1, int idx2, Coordinate[] coordinates) {
        int y1 = coordinates[idx1].getY();
        int x1 = coordinates[idx1].getX();
        int y2 = coordinates[idx2].getY();
        int x2 = coordinates[idx2].getX();

        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }
}

class Coordinate {
    private final int y;
    private final int x;

    public Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}