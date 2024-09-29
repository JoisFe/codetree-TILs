import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
             
            switch (cmd) {
                case "add": 
                map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                break;
                
                case "find":
                Integer findKey = Integer.parseInt(st.nextToken());
                if (map.containsKey(findKey)) {
                    System.out.println(map.get(findKey));
                } else {
                    System.out.println("None");
                }
                break;

                case "remove":
                map.remove(Integer.parseInt(st.nextToken()));
                break;

                case "print_list":
                if (map.entrySet().isEmpty()) {
                    System.out.println("None");
                    continue;
                }
                map.entrySet().stream()
                              .forEach(entry -> System.out.print(entry.getValue() + " "));
                System.out.println();
                break;
            }
        }
    }
}