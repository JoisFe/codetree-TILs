import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;

        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();

            map.compute(nums[i], (key, value) -> value == null ? 1 : ++value);

        }

        for (int i = 0; i < n; ++i) {
            map.compute(nums[i], (key, value) -> value == null ? -1 : --value);

            for (int j = 0; j < i; ++j) {
                if (map.containsKey(k - nums[i] - nums[j])) {
                    answer += map.get(k - nums[i] - nums[j]);
                }
            }
        }

        System.out.println(answer);
    }
}