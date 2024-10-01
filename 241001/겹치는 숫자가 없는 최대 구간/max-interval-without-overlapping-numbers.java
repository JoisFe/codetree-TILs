import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        } 

        boolean[] existNumArray = new boolean[100001];

        int j = 0;
        int maxLen = 0;
        
        for (int i = 0; i < n; ++i) {

            int len = 0;

            while (j < n) {
                if (existNumArray[nums[j]]) {
                    break;
                }
                
                existNumArray[nums[j]] = true;
                ++j;
            }

            existNumArray[nums[i]] = false;

        maxLen = Math.max(maxLen, j - 1 - i + 1);
        }

        System.out.println(maxLen);
    }
}