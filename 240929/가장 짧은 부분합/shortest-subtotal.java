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

        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            
            for (int j = i; j < n; ++j) {
                sum += arr[j];

                if (sum >= s) {
                    answer = Math.min(answer, j - i + 1);

                    break;
                }
            }

            sum -= arr[i];
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }
}