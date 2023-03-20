import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    static int[][] arr;

    public static void main(String[] args) {
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
        int n = 9;

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = n;

        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 선을 하나씩 끊어가며 조회
        int a, b;
        for (int i = 0; i < wires.length; i++) {
            a = wires[i][0];
            b = wires[i][1];

            arr[a][b] = arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            arr[a][b] = arr[b][a] = 1;
        }
        return answer;
    }

    // 각 전력망에 몇개가 있는지 확인
    public static int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[node][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }

        return (int) Math.abs(n - 2 * cnt);
    }
}
