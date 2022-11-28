package BJ.단계별.기본_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978 {
    /*
     * n은 1000 이하의 자연수
     */
    public static boolean[] prime = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        make_prime();

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(tc-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            
            /*
             * 방법 1
             * 시간 : 124ms
             */
            if(!prime[input]) cnt++;

            /*
             * 방법 2. 들어오는 수마다 소수 판별
             */
            boolean isPrime = true;
            if(input == 1) continue;
            for(int i=2; i<=Math.sqrt(input); i++) {
                if(input % i ==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) cnt++;
        }

        System.out.print(cnt);
    }

    /*
     * 방법 1. 입력 정수는 1000 이하의 자연수 이므로 미리 소수 판별을 한다
     * 시간 : 124ms
     */
    public static void make_prime() {
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue; 

            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
