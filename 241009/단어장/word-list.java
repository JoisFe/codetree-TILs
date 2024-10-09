import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            map.compute(sc.next(), (k ,v) -> v == null ? 1 : ++v);
        }

        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}