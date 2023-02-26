package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1527 {
    static int A, B;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(answer);
    }

    /*
     * 메모리 초과
     * 매번 검사할 정수를 문자열로 바꾸는 과정에서 발생하는 메모리 낭비
     */
    public static int solution(int A, int B) {
        answer = 0;

        for(int i=A; i<=B; i++) {
            String num = String.valueOf(i);

            boolean contain47 = true;
            for(int j=0; j<num.length(); j++) {
                if(num.charAt(j) == '4' || num.charAt(j) == '7') continue;
                else {
                    contain47 = false;
                    break;
                }
            }

            if(contain47) answer++;
        }

        return answer;
    }

    public static int solution2(int A, int B) {
        answer = 0;

        for(int i=A; i<=B; i++) {
            boolean contain47 = true;
            
            int n = i;
            while(n>0) {
                int digit = n % 10;

                System.out.println("digit = " + digit + " n = " + n);
                if(digit != 4 || digit != 7) {
                    contain47 = false;
                }

                n /= 10;
            }

            if(contain47) answer++;
        }

        return answer;
    }

    public static void dfs(long num) {
        if(num > B) return;
        if(num >= A && num <= B) answer++;

        dfs(num*10 + 4);
        dfs(num*10 + 7);
    }
}
