import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int k = sc.nextInt();
            Set<Integer> set = new TreeSet<>();

            for (int j = 0; j < k; ++j) {

                char cmd = sc.next().charAt(0);
                int num = sc.nextInt();

                switch (cmd) {
                    case 'I':
                        set.add(num);
                        break;
                    case 'D':
                        if (set.isEmpty()) {
                            break;
                        }
                        int targetNum = 0;
                        if (num == 1) {
                            targetNum = ((TreeSet<Integer>) set).last();
                        } else {
                            targetNum = ((TreeSet<Integer>) set).first();
                        }
                        set.remove(targetNum);
                        break;
                }
            }
            if (set.isEmpty()) {
                System.out.println("EMPTY ");
            } else {
                System.out.println(((TreeSet<Integer>) set).last() + " " + ((TreeSet<Integer>) set).first());
        }
        }
    }
}