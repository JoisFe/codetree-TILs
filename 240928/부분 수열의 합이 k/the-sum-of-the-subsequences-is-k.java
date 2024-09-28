import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[n + 1];

        IntStream.range(1, n + 1).forEach(i -> sumArr[i] = sumArr[i - 1] + arr[i]);

        int cnt = 0;

        for (int i = 0; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (sumArr[j] - sumArr[i] == k) {
                    ++cnt;
                }
            }
        }

        System.out.println(cnt);
    }
}