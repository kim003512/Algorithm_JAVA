package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int range = 2;

        if (n == 1) {
            System.out.println(1);
        } else {
            while (range <= n) {
                range += (6*cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
        
    }
}

