import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[] sumNums = new int[n];

        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sumNums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sumNums[i] = sumNums[i - 1] + nums[i];
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n - k; ++i) {
            answer = Math.max(answer, sumNums[k + i + 1] - sumNums[i]);
        }

        System.out.println(answer);
    }
}