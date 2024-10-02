import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n ];

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        int answer = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < n; ++i) {
            if (sum < 0) {
                sum = nums[i];
                continue;
            }

            sum += nums[i];

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}