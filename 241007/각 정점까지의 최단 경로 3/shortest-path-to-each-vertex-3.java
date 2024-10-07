import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        int[] dists = new int[n + 1];

        Arrays.fill(dists, INF);
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            graph.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        dijkstra(graph, dists, 1);

        for (int i = 2; i <= n; ++i) {
            if (dists[i] == INF) {
                dists[i] = -1;
            }

            System.out.println(dists[i]);
        }
    }

    private static void dijkstra(List<List<Edge>> graph, int[] dists, int startNode) {

        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startNode, 0));
        dists[startNode] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentNode = edge.getNode();
            int currentDist = edge.getDist();

            if (dists[currentNode] < currentDist) {
                continue;
            }

            for (int i = 0; i < graph.get(currentNode).size(); ++i) {
                Edge nextEdge = graph.get(currentNode).get(i);

                int nextNode = nextEdge.getNode();
                int cost = currentDist + nextEdge.getDist();

                if (cost < dists[nextNode]) {
                    dists[nextNode] = cost;

                    pq.add(new Edge(nextNode, cost));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    private final int node;
    private final int dist;

    public Edge(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int getNode() {
        return this.node;
    }

    public int getDist() {
        return this.dist;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.dist, other.dist);
    }
}