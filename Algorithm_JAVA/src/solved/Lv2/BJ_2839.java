package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2839 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        solution2();
    }

    public static void solution1() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        if (n == 4 || n == 7) {
            cnt = -1;
        }
        else if((n%5) == 1 || (n%5) == 3) {
            cnt += (n/5) + 1;
        }
        else if((n%5) == 2 || (n%5) == 4) {
            cnt += (n/5) + 2;
        } 
        else if((n%5) == 0){
            cnt += n/5;
        }

        System.out.println(cnt);
    }

    public static void solution2() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(true) {
            if (n%5 == 0) {
                cnt += n/5;
                break;
            } else if (n<0) {
                cnt = -1;
                break;
            }
            n -= 3;
            cnt++;
        }
        System.out.println(cnt);
    }
}
