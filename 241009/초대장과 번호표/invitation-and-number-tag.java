import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int g = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        set.add(1);

        while (true) {
            int setSize = set.size();

            for (int i = 0; i < g; ++i) {
                int cnt = sc.nextInt();

                int idxSize = cnt;
                int uniqueNum = -1;

                for (int j = 0; j < idxSize; ++j) {
                    int num = sc.nextInt();

                    if (set.contains(num)) {
                        --cnt;
                        continue;
                    }

                    uniqueNum = num;
                }

                if (cnt == 1) {
                    set.add(uniqueNum);
                }
            }

            if (setSize == set.size()) {
                break;
            }
        }

        System.out.println(set.size());
    }
}