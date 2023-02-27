package BJ.브루트포스.Programmers;

public class PRO_피로도 {
    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        //System.out.println(solution(80, dungeons));

        dfs(0, 80, dungeons);
        System.out.println(answer);
    }

    public static int solution2(int k, int[][] dungeons) {
        dfs(k, 0, new boolean[dungeons.length], dungeons);

        return answer;
    }

    public static void dfs(int k, int count, boolean[] visited, int[][] dungeons) {
        if(count > answer) answer = count;

        for(int i=0; i<visited.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k-dungeons[i][1], count+1, visited, dungeons);
                visited[i] = false;
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        int max = -1;
        
        for(int i=0; i<dungeons.length; i++) {
            int nowMax = 0;
            for(int j=i+1; j<dungeons.length; j++) {
                if(dungeons[i][0] <= k) {
                    k -= dungeons[i][1];
                    nowMax++;
                } else break;
            }

            max = (max < nowMax) ? nowMax : max; 
        }
        return max;
    }
}
