import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Node>> reverseGraph = new ArrayList<>();
        int[] dists = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            reverseGraph.add(new ArrayList<>());
        }

        Arrays.fill(dists, INF);

        for (int i = 0; i < m; ++i) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            int dist = sc.nextInt();
            reverseGraph.get(destination).add(new Node(start, dist));
        }

        dijkstra(reverseGraph, dists, n);

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < n; ++i) {
            answer = Math.max(answer, dists[i]);
        }

        System.out.println(answer);
    }

    private static void dijkstra(List<List<Node>> reverseGraph, int[] dists, int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dists[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentIndex = currentNode.getIndex();
            int currentDist = currentNode.getDist();

            if (dists[currentIndex] < currentDist) {
                continue;
            }

            for (int i = 0; i < reverseGraph.get(currentIndex).size(); ++i) {
                Node nextNode = reverseGraph.get(currentIndex).get(i);
                int nextIndex = nextNode.getIndex();
                int nextDist = nextNode.getDist();

                int cost = currentDist + nextDist;

                if (cost < 0) {
                    cost = INF;
                }

                if (dists[nextIndex] < cost) {
                    continue;
                }

                dists[nextIndex] = cost;
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

    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}