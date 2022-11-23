package BJ.수학;

import java.util.Scanner;

public class 소수_판별_알고리즘 {
    public static boolean[] prime;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        is_prime3(N);

        for(int i=0; i<prime.length; i++) {
            if(prime[i] == false) {
                System.out.println(i);
            }
        }

        in.close();
    }
    //N 이하의 수까지 모든 수를 검사하므로 시간 복잡도 = O(N)
    public static void is_prime(int number) {
        if(number < 2) { // 0과 1은 소수가 아니다
            System.out.println("소수가 아닙니다.");
            return;
        }

        if(number == 2) {
            System.out.println("소수입니다.");
            return;
        }

        for(int i=2; i<number; i++) {
            if(number % i == 0) {
                System.out.println("소수가 아닙니다.");
                return;
            }
        }

        System.out.println("소수입니다."); //반복문에서 약수를 갖고 있지 않은 경우 => 소수
        return;
    }

    //2이상 루트N 이하의 수 중에 나누어 떨어지는 수가 존재한다면 소수가 아님을 이용한 소수 판별법
    //루트N 이하의 수까지 모든 수를 검사하므로 => O(루트N)
    public static void is_prime2(int number) {
        if(number < 2) { // 0과 1은 소수가 아니다
            System.out.println("소수가 아닙니다.");
            return;
        }

        if(number == 2) {
            System.out.println("소수입니다.");
            return;
        }

        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i ==0) {
                System.out.println("소수가 아닙니다.");
                return;
            }
        }

        System.out.println("소수입니다."); //반복문에서 약수를 갖고 있지 않은 경우 => 소수
        return;
    }

    /** 
    에라스토스테네스의 체
    k=2부터 루트N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다

    */
    // N 이하 소수 생성 메소드
    public static void is_prime3(int N) {
        prime = new boolean[N+1];

        /**
         * 소수가 아닌 index = true
         * 소수인 index = false
         * N 이하의 소수에 대해 거르는 시간이 logN이므로 단순하게 체에 거르는 것만 해도
         * 시간 복잡도는 O(NlongN)
         */

         //2 미만의 N 을 입력받으면 소수는 판별한 필요 없으므로 바로 return
         if(N<2) {
            return;
         }

         prime[0] = prime[1] = true; // 소수가 아님

         for(int i=2; i<=Math.sqrt(N); i++) {
            //이미 체크한 배열이면 다음 반복문으로 skip
            //중복된 수들은 검사하지 않는다
            if(prime[i] == true) {
                 continue;
            }

            //i의 배수들을 걸러주기 위한 반복문
            for(int j=i*i; j<prime.length; j = j+i) {
                System.out.println("i = " + i +" j = " + j);
                prime[j] = true;
            }
         }
    }
}
