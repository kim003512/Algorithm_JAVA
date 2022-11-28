package BJ.단계별.기본_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_2581 {
    public static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        make_prime();

        /*
         * 방법 1. ArrayList 이용
         * 시간 : 128ms
         */
        List<Integer> arr = new ArrayList<>();
        for(int i=M; i<=N; i++) {
            if(!prime[i]) {
                arr.add(i);
            }
        }

        if(arr.isEmpty()) {
            System.out.print(-1);
        } else {
            System.out.println(arr.stream().mapToInt(Integer::intValue).sum());
            System.out.print(Collections.min(arr));
        }

        /*
         * 방법 2. Integer.MAX_VALUE 이용
         * 시간 : 124ms
         */
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=M; i<=N; i++) {
            if(!prime[i]) {
                if(min > i) min = i;
                sum += i;
            }
        }

        if(sum==0) System.out.print(-1);
        else {
            System.out.println(sum);
            System.out.print(min);
        }
    }

    public static void make_prime() {
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
