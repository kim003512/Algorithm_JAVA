package BJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        bfs(V);
        System.out.println(sb.toString());
    }

    public static void bfs(int v) {
        sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int nowV = queue.poll();
            sb.append(nowV + " ");
            
            for(int i=1; i<=N; i++) {
                if(arr[nowV][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
