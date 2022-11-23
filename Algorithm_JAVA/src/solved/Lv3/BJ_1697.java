package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프 탐색 문제 가장 빠른 시간을 구해야하는 문제 = BFS
// 최단 거리 문제와 유사
public class BJ_1697 {
    static int[] arr;
    static int x, y;
    static int cnt=0;

    //ArrayIndexOutOfRange
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[y+1];
        arr[x] = 0;

        if(x==y) System.out.println(0);
        else bfs(x);
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        
        while(!que.isEmpty()) {
            int x = que.poll();
            for(int i=0; i<3; i++) {
                int move_x;
                if(i==0) {
                    move_x = x-1;
                } else if(i==1) {
                    move_x = x+1;
                } else {
                    move_x = x*2;
                }

                if(move_x==y) {
                    System.out.println(arr[x]+1);
                    return;
                }

                if(move_x<y&& move_x>=0) {
                    if(arr[move_x]==0) {
                        arr[move_x] = arr[x] + 1;
                        que.add(move_x);
                    }
                }
            }
        }
    }
}
