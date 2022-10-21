package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int m, n, k;
    static int[] x_move = {-1, 1, 0, 0};
    static int[] y_move = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            visited = new boolean[m][n];

            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int cnt = 0;
            for(int a=0; a<m; a++) {
                for(int b=0; b<n; b++) {
                    if(!visited[a][b] && arr[a][b]==1) {
                        dfs(a, b);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int move_x = x + x_move[i];
            int move_y = y + y_move[i];

            if(move_x>=0 && move_y>=0 && move_x<m && move_y<n) {
                if(!visited[move_x][move_y] && arr[move_x][move_y]==1) {
                    dfs(move_x, move_y);
                }
            }
        }
    }

    public static void bfs1(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, y});
        visited[x][y] = true;

        while(!que.isEmpty()) {
            int nowX = que.peek()[0];
            int nowY = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++) {
                // nowX += x_move[i];
                // nowY += y_move[i];
                int move_x = nowX + x_move[i];
                int move_y = nowY + y_move[i];

                if(move_x>=0 && move_y>=0 && move_x<m && move_y<n) {
                    if(arr[move_x][move_y]==1 && !visited[move_x][move_y]) {
                        visited[move_x][move_y] = true;
                        que.add(new int[] {move_x, move_y});
                    }
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Integer> xQue = new LinkedList<>();
        Queue<Integer> yQue = new LinkedList<>();
        xQue.offer(x);
        yQue.offer(y);

        while(!xQue.isEmpty() && !yQue.isEmpty()) {
            int nowX = xQue.poll();
            int nowY = yQue.poll();
            visited[nowX][nowY] = true;
        
            for(int i=0; i<x_move.length; i++) {
                
                    // nowX += x_move[i];
                    // nowY += y_move[i];
                    int move_x = nowX + x_move[i];
                    int move_y = nowY + y_move[i];

                    if(move_x>=0 && move_y>=0 && move_x<m && move_y<n) {
                        if(arr[move_x][move_y] == 1 && !visited[move_x][move_y]) {
                            
                            xQue.offer(move_x);
                            yQue.offer(move_y);
                            visited[move_x][move_y] = true;
                        }
                    }
                
            }
        }        
    } 
}
