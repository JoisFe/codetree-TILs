import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; ++i) {
            map[i][i] = 1;
        }

        for (int mid = 0; mid < n; ++mid) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] == 1) {
                        continue;
                    }

                    if (map[i][mid] == 1 && map[mid][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}