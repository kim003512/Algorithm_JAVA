package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] x_move = {-1, 1, 0, 0};
    static int[] y_move = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int m,n;
    static int cnt = 0;
    static Queue<int[]> oneQue;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        oneQue = new LinkedList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if(num == 1) {
                    oneQue.add(new int[] {i, j});
                }
            }
        }
        bfs();
        System.out.println(cnt);
    }

    public static void bfs() {
        cnt++;
        int x = oneQue.peek()[0];
        int y = oneQue.peek()[1];
        oneQue.poll();
        visited[x][y] = true;

        while(!oneQue.isEmpty()) {
            for(int i=0; i<4; i++) {
                int nowX = x + x_move[i];
                int nowY = y + y_move[i];

                if(nowX>=0 && nowY >=0 && nowX<m && nowY<n) {
                    if(arr[nowX][nowY]==0 && !visited[nowX][nowY]) {
                        visited[nowX][nowY] = true;
                        arr[nowX][nowY] = 1;
                        oneQue.add(new int[] {nowX, nowY});
                    }
                }
            }
        }
    }

    // 각 구역마다 한번의 탐색으로 끝내도 될 것을 계속 접근하여 비효율적
    public static void dfs(int x, int y) {
        cnt++;
        visited[x][y] = true;
        oneQue.poll();

        for(int i=0; i<4; i++) {
            int nowX = x + x_move[i];
            int nowY = y + y_move[i];
            if(nowX>=0 && nowY >=0 && nowX<m && nowY<n) {
                System.out.println(visited[nowX][nowY] + " " + arr[nowX][nowY]);
                if(arr[nowX][nowY]==0 && !visited[nowX][nowY]) {
                    System.out.println(nowX + " "+nowY);
                    visited[nowX][nowY] = true;
                    arr[nowX][nowY] = 1;
                    oneQue.add(new int[] {nowX, nowY});
                    dfs(nowX, nowY);
                }
            }
        }
    }

}
