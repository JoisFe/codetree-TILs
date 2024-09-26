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

        int answer = sumNums[k - 1];

        for (int i = 0; i < n - k - 1; ++i) {
            // sumNums(k - 1)
            // sumNums(k) - sumNums(0)
            // sumNums(k + 1) - sumNums(1) 
            // sumNums(k + 2) - sumNums(2)
            answer = Math.max(answer, sumNums[k + i] - sumNums[i]);
        }

        System.out.println(answer);
    }
}