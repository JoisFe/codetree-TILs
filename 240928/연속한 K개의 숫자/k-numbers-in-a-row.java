import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);

        for (int i = 0 ; i < b; ++i) {
            int idx = sc.nextInt();
            arr[idx] = 0;
        }

        int[] sumArr = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - k + 1 ; ++i) {
            max = Math.max(max, sumArr[i + k] - sumArr[i]);
        }

        System.out.println(k - max);
    }
}