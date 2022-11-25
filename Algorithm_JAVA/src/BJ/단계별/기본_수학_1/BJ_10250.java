package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 반례생각해보기
 * 시간 : 124ms
 */
public class BJ_10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            /**
             * 층수 = 무조건 100 자리수부터 시작 => 100 곱해준다
             */
            if(n%h==0) {
                sb.append((h*100) + (n/h)).append('\n');
            } else {
                sb.append((n%h)*100 + (n/h)+1).append('\n');
            }
        }

        System.out.print(sb);
    }
}
