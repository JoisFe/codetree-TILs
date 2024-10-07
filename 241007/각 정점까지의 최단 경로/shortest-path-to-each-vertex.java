import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        int[] dists = new int[n + 1];

        Arrays.fill(dists, INF);
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            int dist = sc.nextInt();

            graph.get(index1).add(new Node(index2, dist));
            graph.get(index2).add(new Node(index1, dist));
        }

        dijkstra(graph, dists, k);

        for (int i = 1; i <= n; ++i) {
            if (dists[i] == INF) {
                dists[i] = -1;
            }

            System.out.println(dists[i]);
        }
    }

    private static void dijkstra(List<List<Node>> graph, int[] dists, int startNode) {

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));
        dists[startNode] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentIndex = node.getIndex();
            int currentDist = node.getDist();

            if (dists[currentIndex] < currentDist) {
                continue;
            }

            for (int i = 0; i < graph.get(currentIndex).size(); ++i) {
                Node nextNode = graph.get(currentIndex).get(i);

                int nextIndex = nextNode.getIndex();
                int cost = currentDist + nextNode.getDist();

                if (cost < dists[nextIndex]) {
                    dists[nextIndex] = cost;

                    pq.add(new Node(nextIndex, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    private final int index;
    private final int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDist() {
        return this.dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}