package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 120ms
 */
public class BJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 1; // 최소 방 수
        int range = 2; // 최소 범위 수

        if(n == 1) {
            System.out.print(1);
        }
        else {
            while(range <= n) {
                /*
                 * 6 -> 12 -> 18 ... 6의 배수 기준으로 방이 늘어남
                 */
                range = range + (6*cnt);
                cnt++;
            }
            System.out.print(cnt);
        }
    }
}
