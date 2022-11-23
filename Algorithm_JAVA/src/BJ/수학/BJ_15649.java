package BJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제에서 N과 M이 주어지고, 중복된 수를 제외한 모든 경우의 수를 탐색하면됨
 * 즉, 재귀 방법을 통해 풀어볼 수 있음
 */
public class BJ_15649 {
    static StringBuilder sb = new StringBuilder();
    /*
    이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해(유망한 노드인지 검사)
    N 크기의 boolean 배열

    탐색 과정에서 값을 담을
    int 배열 arr
     */
    static int[] arr;
    static boolean[] visit; 
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for(int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
