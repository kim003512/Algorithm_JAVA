package BJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_6588 {
    public static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        get_prime();

        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;
            
            boolean check = false;
            
            for(int i=2; i<=n/2; i++) {
                if(!prime[i] && !prime[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append('\n');
                    check = true;
                    break;
                }
            }

            if(!check) sb.append("Goldbach's conjecture is wrong.").append('\n'); 
        }

        System.out.print(sb);
    }   

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;

            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
