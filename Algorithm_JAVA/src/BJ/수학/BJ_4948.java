package BJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4948 {
    /**
     * n > 123456 이므로 2n은 최대 246913
     * 0부터 시작하므로 246912 + 1
     */
    public static boolean[] prime = new boolean[246913];
    public static int[] count = new int[246913];
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        get_prime();
        get_count();
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            // int cnt=0;
            // for(int i=n+1; i<=2*n; i++) {
            //     if(!prime[i]) cnt++;
            // }

            // sb.append(cnt).append('\n');
            sb.append(count[2*n] - count[n]).append('\n');
        }

        System.out.print(sb);
    }  

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;

            for(int j=i*i; j<prime.length; j +=i) {
                prime[j] = true;
            }
        }
    }

    public static void get_count() {
        int cnt = 0;
        for(int i=2; i<prime.length; i++) {
            if(!prime[i]) cnt++;

            count[i] = cnt;
        }
    }
}
