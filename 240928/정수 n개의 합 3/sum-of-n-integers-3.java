import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] squares = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                squares[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumSquares = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sumSquares[i][j] = sumSquares[i - 1][j] + sumSquares[i][j - 1] - sumSquares[i - 1][j - 1] + squares[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n - k + 1; ++i) {
            for (int j = 1; j <= n - k + 1; ++j) {
                answer = Math.max(answer, sumSquares[i + k - 1][j + k - 1] - sumSquares[i - 1][j + k - 1] - sumSquares[i + k - 1][j - 1] + sumSquares[i - 1][j - 1]);
            }
        }

        System.out.println(answer);
    }
}