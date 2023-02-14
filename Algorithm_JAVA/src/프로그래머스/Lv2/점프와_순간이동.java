package 프로그래머스.Lv2;

public class 점프와_순간이동 {
    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static int solution(int n) {
        int ans = 0;

        if(n <= 2) ans = 1;
        else {
            while(true) {
                if(n % 2 == 0) {
                    n /= 2;
                }
                else{
                    n -= 1;
                    ans++;
                }

                if(n <= 2) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
