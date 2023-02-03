package 프로그래머스.Lv1;

public class 소수_찾기 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i++) {
            for(int j=2; j<=i; j++) {
                if(i%j==0) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static int solution3(int n) {
        int answer = 0;

        for(int i=2; i<n+1; i++) {
            if(isPrime(i)) answer++;
        }

        return answer;
    }

    public static boolean isPrime(int num) {
        for(int i=2; i*i<=num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    /**
     * 에라스토테네스의 체
     * 특정 수가 소수인지 판별하는 경우에는 비효율적
     * */
    public static int solution2(int n) {
        int answer = 0;
        int[] numbers = new int[n+1];

        for(int i=2; i<=n; i++) {
            numbers[i] = i;
        }

        for(int i=2; i<n; i++) {
            if(numbers[i] == 0) continue;

            for(int j=2*i; j<=n; j+=i) numbers[j] = 0;
        }

        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] != 0) answer++;
        }
        return answer;
    }
}
