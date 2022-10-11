package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0; //최대공약수

        for(int i=1; i<=n; i++) {
            if(n % i == 0 && m % i==0) {
                max = i;
            }
        }

        int min = (n*m)/max;

        sb.append(max).append('\n');
        sb.append(min);

        System.out.println(sb);

        System.out.println(getGCD(n, m));
        System.out.println(getLCM(n, m, getGCD(n, m)));
    }

    public static int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = 0;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static int getLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
