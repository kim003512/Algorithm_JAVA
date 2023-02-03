package 프로그래머스.Lv1;

public class 콜라_문제 {
    public static void main(String[] args) {
        System.out.println(solution(3, 1, 20));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        //int nowN = n;
        while(true) {
            if(n < a) break;
            answer += (n/a) * b;

            n = ((n/a)*b) + (n%a);

            // if(n % a == 0) {
            //     answer = nowN - n + (n/a);
            // } else {
            //     n--;
            // }
        }

        return answer;
    }
}
