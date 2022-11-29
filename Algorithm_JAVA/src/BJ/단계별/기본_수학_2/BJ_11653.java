package BJ.단계별.기본_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 124ms
 */
public class BJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=Math.sqrt(N); i++) {
            while(N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }
        if(N != 1) sb.append(N);

        // while(N != 0) {
        //     for(int i=2; i<=N; i++) {
        //         if(N % i == 0) {
        //             System.out.println(i);
        //             N = N/i;
        //             sb.append(i).append('\n');
        //             break;
        //         }
        //     }
        // }
        System.out.print(sb);
    }
}
