package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited;
    static int[][] connected;
    static int com, connect;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static int dfs(int start) {
        visited[start] = 1;

        for(int i=1; i<=com; i++) {
            if(connected[start][i]==1 && visited[i]==0) {
                cnt++;
                dfs(i);
            }
        }
        return cnt;
    }

    public static void solution() throws IOException {
        com = Integer.parseInt(br.readLine());
        connect = Integer.parseInt(br.readLine());
        
        visited = new int[com+1];
        connected = new int[com+1][com+1];

        for(int i=0; i<connect; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connected[a][b] = connected[b][a] = 1;
        }

        System.out.println(bfs(1));
    }
    public static int bfs(int i) {
        System.out.println(i);
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        visited[i] = 1;

        while(!que.isEmpty()) {
            int temp = que.poll();

            for(int j=1; j<=com; j++) {
                if(connected[temp][j] ==1 && visited[j] == 0) {
                    que.offer(j);
                    visited[j] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
