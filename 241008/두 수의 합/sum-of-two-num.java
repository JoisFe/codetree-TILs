import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        int answer = 0;

        while (leftIdx < rightIdx) {
            int sum = nums[leftIdx] + nums[rightIdx];

            if (sum == k) {
                ++answer;
                ++leftIdx;
            } else if (sum > k) {
                --rightIdx;
            } else {
                ++leftIdx;
            }
        }

        System.out.println(answer);
    }
}