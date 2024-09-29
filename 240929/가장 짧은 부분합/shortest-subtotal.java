import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            while (j < n && sum + arr[j] <= s) {
                sum += arr[j];
                ++j;
            }

            if (sum < s) {
                break;
            }

            answer = Math.max(answer, j - i + 1);

            sum -= arr[i];
        }

        System.out.println(answer);
    }
}