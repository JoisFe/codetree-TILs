import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int[] innerMap : map) {
            Arrays.fill(innerMap, INF);
        }

        for (int i = 1; i <= n; ++i) {
            map[i][i] = 0;
        }

        for (int i = 0; i < m; ++i) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            
            map[start][end] = Math.min(map[start][end], dist);
        }

        for (int mid = 1; mid <= n; ++mid) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    int dist = map[i][mid] + map[mid][j];
                    
                    if (dist < 0) {
                        dist = INF;
                    }

                    map[i][j] = Math.min(map[i][j], dist);
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int dist = map[i][j];
                
                if (dist == INF) {
                    dist = -1;
                }

                System.out.print(dist + " ");
            }
            System.out.println();
        }
    }
}