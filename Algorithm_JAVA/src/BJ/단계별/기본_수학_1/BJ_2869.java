package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수학 문제의 경우 계산식을 찾도록 노력
 * 무작정 특정 수에 도달하기 까지 계산을 계속해서 하면 -> 시간의 문제
 * 계산식을 찾은 후 조건을 찾도록
 * 
 * 시간 : 124ms
 */
public class BJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        /*
         * 조건 : 정점에 도달하면 미끄러지지 않는다
         * -> 잔여블록이 있다면 미끄러진 후에 다시 올라가야 함 == day++
         * 
         * 
         */
        int day = (V-B) / (A-B);

        if((V-B) % (A-B) > 0) day++;

        System.out.print(day);

        /*
         * 너무 많은 시간 소요 -> 데이터가 커질수록 많은 계산을 반복하게 됨
         * 답도 틀림
        */
        int now = 0;
        int cnt = 0;
        while (true) {
            now = (now + A) - B;
            if (now >= V) break;
            cnt++;
        }

        System.out.print(cnt); 
    }
}
