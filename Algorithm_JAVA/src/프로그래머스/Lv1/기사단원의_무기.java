package 프로그래머스.Lv1;

public class 기사단원의_무기 {
    public static void main(String[] args) {
        System.out.println(solution4(5, 3, 2));
    }

    //시간 초과
    public static int solution(int number, int limit, int power) {
        int answer = 0;

        int[] list = new int[number+1];
        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=i; j++) {
                if(i%j==0) cnt++;
            }
            list[i] = cnt;
        }

        for(int i=0; i<list.length; i++) {
            if(list[i] > limit) list[i] = power;
        }

        for(int i : list) answer += i;

        return answer;
    }

    public static int solution2(int number, int limit, int power) {
        int answer = 0;
        int[] list = new int[number+1];

        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j*j<=i; j++) {
                if(j*j == i) cnt++;
                else if(i % j == 0) cnt += 2;
            }
            list[i] = cnt > limit ? power : cnt;
            answer += list[i];
        }

        return answer;
    }

    public static int solution3(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j*j<=i; j++) {
                if(j *j == i) cnt++;
                else if(i%j == 0) cnt+=2;
            }
            answer += (cnt > limit) ? power : cnt;
        }

        return answer;
    }

    public static int solution4(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(j *j == i) cnt++;
                else if(i%j == 0) cnt+=2;
            }
            answer += (cnt > limit) ? power : cnt;
        }

        return answer;
    }
}
