import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] rockScissorsPapers = {'H', 'S', 'P'};
        char[] arr = new char[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = sc.next().charAt(0);
        }

        int[] lArr = new int[n];
        int[] rArr = new int[n];

        for (int i = 0; i < 3; ++i) {
            int cnt = 0;

            for (int j = 0; j < n; ++j) {
                // 비기는 경우가 아니라 ex) 묵이랑 같은케이스가 사실 빠인것임 (묵을 이기는 케이스)
                if (arr[j] == rockScissorsPapers[i]) {
                    ++cnt;
                }

                lArr[j] = Math.max(lArr[j], cnt);
            }

            cnt = 0;

            for (int j = n - 1; j >= 0; --j) {
                if (arr[j] == rockScissorsPapers[i]) {
                    ++cnt;
                }

                rArr[j] = Math.max(rArr[j], cnt);
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; ++i) {
            answer= Math.max(answer, lArr[i] + rArr[i + 1]);
        }

        System.out.println(answer);
    }
}