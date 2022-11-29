package BJ.단계별.기본_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9020 {
    /*
     * 최대범위만큼 한번만 돌릴 경우
     * 시간 : 164ms
     */
    static boolean[] prime;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) {
            n = Integer.parseInt(br.readLine());

            /*
             * 매번 돌림
             * 시간 : 256ms
             */
            get_prime();
            int first = n/2;
            int second = n/2;

            while(true) {
                if(!prime[first] && !prime[second]) {
                    sb.append(first).append(' ').append(second).append('\n');
                    break;
                }
                first--;
                second++;
            }
        }

        /*
        while(tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            get_prime();

            while(n != 0) {
                for(int i=0; i<=n; i++) {
                    if(!prime[i]) {
                        sb.append(i).append(' ');
                        n -=i;
                    }
                }
            }
            sb.append('\n');
        } */

        System.out.print(sb);
    }

    public static void get_prime() {
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
