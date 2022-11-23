package BJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1929 {
    public static boolean[] prime;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        get_prime();

        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++) {
            if(!prime[i]) sb.append(i).append('\n');
        }

        System.out.print(sb);
    }

    public static void get_prime() {
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        
        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;

            for(int j=i*i; j<prime.length; j=j+i) {
                prime[j] = true;
            }
        }
    }

    // 시간초과
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        for(int i=m; i<=n; i++) {
            int cnt = 0;
            for(int j=2; j<=i; j++) {
                if(i % j == 0) cnt++;
            }
            if(cnt < 2) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}
