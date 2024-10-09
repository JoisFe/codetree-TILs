import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 1; i <= n; ++i) {
            final int idx = i;
            map.compute(sc.nextInt(), (k, v) -> v == null ? idx : v);
        }

        map.entrySet().stream()
                      .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}