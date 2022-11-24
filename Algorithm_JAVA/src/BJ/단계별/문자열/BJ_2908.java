package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /*
         * 방법 2. 단위별로 % / 를 통해 뒤집기
         * 틀림 why .. 
         */
        String[] input = br.readLine().split(" ");
        int a = reRead(Integer.parseInt(input[0]));
        int b = reRead(Integer.parseInt(input[1]));

        /*
         * 방법 2. StringBuilder의 reverse() 사용
         * 시간 : 120ms
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        
        System.out.print(A>B? A:B);
    }

    public static int reRead(int num) {
        int ans = 0;

        while(num != 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }
}
