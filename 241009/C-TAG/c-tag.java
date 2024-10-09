import java.util.*;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] strArrayA = new String[n];
        String[] strArrayB = new String[n];

        for (int i = 0; i < n; ++i) {
            strArrayA[i] = sc.next();
        }

        for (int i = 0; i < n; ++i) {
            strArrayB[i] = sc.next();
        }

        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                for (int k = j + 1; k < m; ++k) {
                    Set<String> set = new HashSet<>();

                    for (int cnt = 0; cnt < n; ++cnt) {
                        set.add("" + strArrayA[cnt].charAt(i) + strArrayA[cnt].charAt(j) + strArrayA[cnt].charAt(k));
                    }

                    boolean check = true;

                    for (int cnt = 0; cnt < n; ++cnt) {
                        if (set.contains("" + strArrayB[cnt].charAt(i) + strArrayB[cnt].charAt(j) + strArrayB[cnt].charAt(k))) {
                            check = false;
                            break;
                        }
                    }

                    if (check) {
                        ++answer;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}