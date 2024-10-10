import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            
            String cmd = st.nextToken();
            int num = 0;

            switch(cmd) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "find":
                    num = Integer.parseInt(st.nextToken());
                    String str = set.contains(num) ? "true" : "false";
                    System.out.println(str);
                    break;
                case "lower_bound":
                    num = Integer.parseInt(st.nextToken());
                    System.out.println(Optional.ofNullable(String.valueOf(((TreeSet<Integer>) set).ceiling(num))).orElse("None"));
                    break;
                case "upper_bound":
                    num = Integer.parseInt(st.nextToken());
                    System.out.println(Optional.ofNullable(String.valueOf(((TreeSet<Integer>) set).higher(num))).orElse("None"));
                    break;
                case "largest":
                    // System.out.println(Optional.ofNullable(String.valueOf(((TreeSet<Integer>) set).last())).orElse("None"));
                    if (set.isEmpty()) {
                        System.out.println("None");
                        break;
                    }
                    System.out.println(((TreeSet<Integer>) set).last());
                    break;
                case "smallest":
                    // System.out.println(Optional.ofNullable(String.valueOf(((TreeSet<Integer>) set).first())).orElse("None"));
                    if (set.isEmpty()) {
                        System.out.println("None");
                        break;
                    }
                    System.out.println(((TreeSet<Integer>) set).first());
                    break;
            }
        }
    }
}