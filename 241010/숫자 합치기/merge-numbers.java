import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            pq.offer(sc.nextInt());
        }

        int answer = 0;

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            int cost = num1 + num2;

            pq.offer(cost);
            answer += cost;
        }

        System.out.println(answer);
    }
}