import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Double> dictionary = new TreeMap<>();

        int sum = 0;

        for (int i = 0; i < n; ++i) {
            dictionary.compute(sc.next(), (k, v) -> v == null ? 1 : ++v);
            ++sum;
        }

        final int totalSum = sum;

        dictionary.entrySet().stream().forEach(entry -> {
            double ratio = entry.getValue() / totalSum * 100;

            System.out.printf("%s %.4f\n", entry.getKey(), ratio);
        });

    }
}