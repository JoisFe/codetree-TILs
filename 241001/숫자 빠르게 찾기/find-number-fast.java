import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < m; ++i) {
            System.out.println(findNum(sc.nextInt(), nums));
        }
    }

    static int findNum(int num, int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;

            if (nums[midIdx] == num) {
                return midIdx + 1;
            }

            if (nums[midIdx] < num) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }

        return -1;
    }
}