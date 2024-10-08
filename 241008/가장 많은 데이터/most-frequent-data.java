import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            String color = sc.next();

            map.compute(color, (k, v) -> v == null ? 1 : ++v);
        }

        System.out.println(map.values().stream().sorted(Comparator.reverseOrder()).findFirst().orElse(null));
    }
}