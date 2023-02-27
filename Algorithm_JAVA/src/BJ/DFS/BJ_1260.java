package BJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1260 {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            arr[a][b] = arr[b][a] = 1;
        }

        dfs_stack(V);
    }

    //재귀 dfs
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=1; i<= N; i++) {
            if(arr[v][i] == 1 && !visited[i]) dfs(i);
        }
    }

    //stack dfs
    public static void dfs_stack(int v) {
        Stack<Integer> stack = new Stack<>();
        
        stack.add(v);

        while(!stack.isEmpty()) {
            int num = stack.pop();
            visited[num] = true;
            System.out.print(num + " ");

            for(int i=1; i<=N; i++) {
                if(!visited[i] && arr[num][i] == 1) {
                    stack.push(i);
                    break;
                }
            }
        }
    }
}
