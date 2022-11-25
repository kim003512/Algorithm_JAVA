package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V-B) / (A-B);

        if((V-B) % (A-B) > 0) day++;

        System.out.print(day);

        /*
         * 너무 많은 시간 소요 -> 데이터가 커질수록 많은 계산을 반복하게 됨
         * 답도 틀림
        
        int now = 0;
        int cnt = 0;
        while (true) {
            now = (now + A) - B;
            if (now >= V) break;
            cnt++;
        }

        System.out.print(cnt); */
    }
}
