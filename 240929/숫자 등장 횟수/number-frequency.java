import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            map.compute(Integer.parseInt(st.nextToken()), (k, v) -> v == null ? 1 : ++v);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            System.out.print(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
        }
    }
}