package BJ.수학;

public class 최대공약수_최소공배수 {

    // 반복문 방식
    public int gcd(int a, int b) {
        while(b != 0) {
            int r = a%b;

            //GCD(a, b) = GCD(b, r)로 변환
            a=b;
            b=r;
        }
        return a;
    }

    // 재귀 방식
    public int gcd2(int a, int b) {
        if(b==0) return a;
        return gcd(b, a% b);
    }

    // 최소 공배수
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
