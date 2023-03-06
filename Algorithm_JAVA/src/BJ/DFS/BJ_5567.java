package BJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_5567 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        // bfs(1);
        dfs(1, 0);
        System.out.println(cnt); // 상근이 본인 제외
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int nowV = queue.poll();
            cnt++;

            for (int i = 1; i <= n; i++) {
                if (!(nowV == 1)) {
                    if (arr[nowV][i] == 1 && !visited[i] && arr[nowV][1] == 1) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                } else {
                    if (arr[nowV][i] == 1 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public static void dfs(int v, int cnt) {
        if (cnt >= 2)
            return;

        for(int i=1; i<=n; i++) {
            if(arr[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt++);
            }
        }
    }
}
