import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

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
            changes[i][0] = sc.nextInt();
            changes[i][1] = sc.nextInt();
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
            System.out.println(personSet[i].size());
        }
    }
}