package BJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2644 {
    static int[][] arr;
    static boolean[] visited;
    static int n, x, y, m;
    static int count = -1;
    static boolean connect = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(x, y, 0);
        System.out.println(count);
    }

    public static void dfs(int start, int end, int cnt) {
        if(start == end) {
            count = cnt;
            return;
        }
        visited[start] = true;

        for(int i=1; i<=n; i++) {
            if(!visited[i] && arr[start][i] == 1) {
                dfs(i, end, cnt+1);
            }
        }
    }

    public static int dfs2(int node) {
        visited[node] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            int nowNode = stack.pop();
            for(int i=1; i<=n; i++) {
                if(!visited[i] && arr[nowNode][i] == 1) {
                    count++;
                    if(i == y) {
                        return count;
                    }
                    stack.push(i);
                    break;
                }
            }
        }

        return -1;
    }
}
