import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] strs = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; ++i) {
            String str = sc.next();
            
            strs[i] = str;
            map.put(str, i);
        }

        for (int i = 0; i < m; ++i) {
            String str = sc.next();

            if (isNumeric(str)) {
                System.out.println(strs[Integer.parseInt(str)]);
                continue;
            }

            System.out.println(map.get(str));
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}