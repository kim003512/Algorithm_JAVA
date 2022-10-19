package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
       
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}

