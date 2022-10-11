package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int x = (n % h == 0) ? n/h : (n/h)+1;
            int y = (n % h == 0) ? h * 100 : (n % h)*100; //최소 100의 자릿수부터 시작

            sb.append(y+x).append('\n');
        }
        System.out.print(sb);
    }
}
