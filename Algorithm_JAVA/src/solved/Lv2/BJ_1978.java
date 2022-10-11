package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int num;

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());

            for (int j = 2; j <= num; j++) {
                if(j==num) cnt++;
                if (num % j == 0) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}