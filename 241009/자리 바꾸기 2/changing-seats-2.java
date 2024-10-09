import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BuffredReader br = new BuffredReader(new InputStreamReader(System.in));
        BuffredWriter bw = new BuffredWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set[] personSet = new Set[n + 1];
        int[][] changes = new int[k * 3][2];
        int[] seats = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            personSet[i] = new HashSet<>();
        }

        for (int i = 1; i <= n; ++i) {
            seats[i] = i;
            personSet[seats[i]].add(i);
        }

        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            
            changes[i][0] = Integer.parseInt(st.nextToken());
            changes[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; ++i) {
            for (int multi = 1; multi <= 2; ++multi) {
                changes[i + k * multi][0] = changes[i][0];
                changes[i + k * multi][1] = changes[i][1];
            }
        }


        for (int i = 0; i < 3 * k; ++i) {
            int tmp = seats[changes[i][0]];
            seats[changes[i][0]] = seats[changes[i][1]];
            seats[changes[i][1]] = tmp;

            personSet[seats[changes[i][0]]].add(changes[i][0]);
            personSet[seats[changes[i][1]]].add(changes[i][1]);
        }

        for (int i = 1; i <= n; ++i) {
            bw.write(personSet[i].size() + "\n");
        }

        bw.flush();
        bw.close();
    }
}