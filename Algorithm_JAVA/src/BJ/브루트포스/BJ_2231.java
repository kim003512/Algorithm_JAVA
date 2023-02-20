package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(solution(N));
    }

    public static int solution(int N) {
        int answer = 0;

        for(int i=1; i<N; i++) {
            int sum = i;
            int num = i;

            while(num > 0) {
                sum += num%10;
                num /= 10;
            }

            if(sum == N) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
