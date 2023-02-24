package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(solution(num));
    }

    public static int solution(int num) {
        int answer = 0;
        int n = 0;

        for (int i = 1; i <= num; i++) {
            n = i;
            while (n != 0) {
                if ((n % 10) == 3 || (n % 10) == 6 || (n % 10) == 9)
                    answer++;

                n /= 10;
            }
        }

        return answer;
    }

    public static int solution2(int num) {
        String sN = "";
        int result = 0;

        char n;
        for (int i = 1; i <= num; i++) {
            sN = Integer.toString(i);

            for (int j = 0; j < sN.length(); j++) {
                n = sN.charAt(j);

                if (n == '3' || n == '6' || n == '9')
                    result++;
            }
        }

        return result;
    }
}
