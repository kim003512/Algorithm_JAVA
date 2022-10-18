package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<41; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            sb.append(dp[num][0]+" "+dp[num][1]).append('\n');
        }
        System.out.print(sb);
    }
}
