package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2501 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, K));
    }

    public static int solution(int N, int M) {
        for(int i=1; i<=N; i++) {
            if(N % i == 0) {
                arr.add(i);
            }
        }

        if(M-1 >= arr.size()) return 0;
        else {
            return (arr.isEmpty()) ? 0 : arr.get(M-1);
        }
    }

    public static int solution2(int N, int K) {
        int count = 0;
        int result = 0;

        for(int i=1; i<=N; i++) {
            if(N % i == 0) {
                count++;
            }

            if(count == K) {
                result = i;
                break;
            }
        }

        return result;
    }
}