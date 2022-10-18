package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] dp; //메모이제이션 할 배열
    public static void main(String[] args) throws IOException {
        useDP();
    }

    public static void useDP() throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] +1;
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[n]);
    }



    //틀림
    public static void solution1() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 1; 
        while(true) {
            if(n==num) break;
            if(num*3 <= n) {
                num *=3;
                cnt++;
            } else if(num*2 <= n) {
                num *= 2;
                cnt++;
            } else {
                num += 1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
