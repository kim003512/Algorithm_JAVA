package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int n, m;
    static int[][] maps ={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    public static void main(String[] args) {
        visit = new boolean[maps.length][maps[0].length];

        bfs(0, 0, maps);
    }

    public static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int bfs(int x, int y, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,1));
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == n-1 && node.y == m-1) return node.cost;
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(maps[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.offer(new Node(nx, ny, node.cost+1));
                    }
                }
            }
        }
        return -1;
    }
}
