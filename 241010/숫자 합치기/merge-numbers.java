import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            nums.add(sc.nextInt());
        }

        int answer = 0;

        while (true) {
            if (nums.size() == 1) {
                break;
            }

            nums = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            int num1 = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);
            int num2 = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);

            int cost = num1 + num2;

            nums.add(cost);
            answer += cost;

        }

        System.out.println(answer);
    }
}