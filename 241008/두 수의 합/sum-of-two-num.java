import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int nums[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = 0; i < n; ++i) {
            int diffNum = k - nums[i];

            if (map.containsKey(diffNum)) {
                answer += map.get(diffNum);
            } 

            map.compute(nums[i], (key, value) -> value == null ? 1 : ++value);
        }

        System.out.println(answer);
    }
}