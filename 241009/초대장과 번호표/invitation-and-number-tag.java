import java.util.*;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int g = sc.nextInt();

        List<Set<Integer>> groupSetList = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        boolean[] check = new boolean[n + 1];

        for (int i = 0; i < g; ++i) {
            groupSetList.add(new HashSet<>());
        }

        for (int i = 0; i <= n; ++i) {
            groupGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < g; ++i) {
            int cnt = sc.nextInt();

            for (int j = 0; j < cnt; ++j) {
                int peopleNum = sc.nextInt();

                groupSetList.get(i).add(peopleNum); // i번째 그룹에 num 사람이 존재
                groupGraph.get(peopleNum).add(i); // num 사람이 i번재 그룹으로 이동가능
            }
        } 

        bfs(groupSetList, groupGraph, check);

        System.out.println(answer);
    }

    private static void bfs(List<Set<Integer>> groupSetList, List<List<Integer>> groupGraph, boolean[] check) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        check[1] = true;

        while (!q.isEmpty()) {
            int peopleNum = q.poll();
            ++answer;

            // num 이 들어가 있는 모든 그룹 조회하면서 num은 이미 초대장 받았으니 제거 (방문 후 제거 라 보면됨)
            for (int i = 0; i < groupGraph.get(peopleNum).size(); ++i) {
                int nextGroup =  groupGraph.get(peopleNum).get(i);

                groupSetList.get(nextGroup).remove(peopleNum);

                if (groupSetList.get(nextGroup).size() == 1) {
                    int nextPeopleNum = new ArrayList<>(groupSetList.get(nextGroup)).get(0);

                    if (!check[nextPeopleNum]) {
                        check[nextPeopleNum] = true;
                        q.offer(nextPeopleNum);
                    }
                }
            }
        }
    }
}