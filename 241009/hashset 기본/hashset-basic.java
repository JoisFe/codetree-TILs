import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            switch(cmd) {
                case "find" : 
                    if (set.contains(num)) {
                        bw.write("true\n");
                    } else {
                        bw.write("false\n");
                    }

                    break;
                case "add" :
                    set.add(num);
                    break;
                case "remove" :
                    set.remove(num);
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}