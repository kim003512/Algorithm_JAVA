package BJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1388 {
    static int answer = 0;
    static int N, M;
    static boolean[][] visited;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new char[N][M];

        // for(int i=0; i<arr.length; i++) {
        // String str = br.readLine();
        // for(int j=0; j<arr[i].length; j++) {
        // arr[i][j] = str.charAt(j);
        // }
        // }

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        //solution 1
        solution();

        //dfs
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) continue;
                if(arr[i][j] == '-') dfs(i, j, true);
                else dfs(i, j, false);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void solution() {
        //가로('-') 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '-') {
                    answer++;
                    while (j < M && arr[i][j] == '-') {
                        j++;
                    }
                }
            }
        }

        //세로('|') 확인
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(arr[j][i] == '|') {
                    answer++;
                    while(j < N && arr[j][i] =='|') {
                        j++;
                    }
                }
            }
        }
    }

    public static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;
        
        if(row) {
            j++;
            if(j<M && arr[i][j] == '-') dfs(i, j, true);
        } else {
            i++;
            if(i<N && arr[i][j] == '|') dfs(i, j, false);
        }
    }
}
