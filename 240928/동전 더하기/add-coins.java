import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; ++i) {
            coins[i] = sc.nextInt();
        }

        coins = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int cnt = 0;

        for (int coin : coins) {
            if (k == 0) {
                break;
            }
            cnt += k / coin;
            k %= coin;
        }

        System.out.println(cnt);
    }
}