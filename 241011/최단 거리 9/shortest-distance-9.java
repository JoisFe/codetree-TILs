import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < m; ++i) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int distance = sc.nextInt();
            
            graph.get(node1).add(new Node(node2, distance));
            graph.get(node2).add(new Node(node1, distance));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(graph, dist, path, start);

        System.out.println(dist[end]);
        
        int index = end;

        Stack stack = new Stack();
        stack.push(index);

        while (path[index] != 0) {
            stack.push(path[index]);

            index = path[index];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dijkstra(List<List<Node>> graph, int[] dist, int[] path, int index) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(index, 0));
        dist[index] = 0;

        while (!pq.isEmpty()) {
            Node startNode = pq.poll();
            int startIndex = startNode.getIndex();
            int startDist = startNode.getDist();

            if (dist[startIndex] < startDist) {
                continue;
            }

            for (int i = 0; i < graph.get(startIndex).size(); ++i) {
                Node nextNode = graph.get(startIndex).get(i);
                int nextIndex = nextNode.getIndex();
                int nextDist = nextNode.getDist();

                int cost = startDist + nextDist;

                if (cost < 0) {
                    cost = INF;
                }

                if (dist[nextIndex] < cost) {
                    continue;
                }

                dist[nextIndex] = cost;
                path[nextIndex] = startIndex;
                pq.offer(new Node(nextIndex, cost));

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