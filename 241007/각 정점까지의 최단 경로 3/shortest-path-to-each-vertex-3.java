import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge> graph = new ArrayList<>();
        int[] dists = new int[n + 1];

        Arrays.fill(dists, INF);
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            graph.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        dijkstra(graph, dists, 1);

        for (int i = 1; i <= n; ++i) {
            if (dists[i] == INF) {
                dists[i] = -1;
            }

            System.out.print(dists[i] + " ");
        }
    }
}

class Edge implements Comparable<Edge> {
    private int node;
    private int dist;

    public int getNode() {
        return this.node;
    }

    public int getDist() {
        return this.dist;
    }

    @Override
    public int comareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}