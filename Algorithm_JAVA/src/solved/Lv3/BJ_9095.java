package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11]; //최대 11까지 들어올 수 있음
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // for(int i=4; i<11; i++) {
        //     dp[i] = dp[i-1] +dp[i-2] +dp[i-3];
        // }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            for(int j=4; j<=num; j++) {
                dp[j] = dp[j-1] +dp[j-2] +dp[j-3];
            }
            sb.append(dp[num]).append("\n");
        }

        System.out.print(sb);
    }
}
