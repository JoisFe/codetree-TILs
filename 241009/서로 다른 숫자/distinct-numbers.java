import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        IntStream.range(0, n).forEach(i -> set.add(sc.nextInt()));

        System.out.println(set.size());
    }
}