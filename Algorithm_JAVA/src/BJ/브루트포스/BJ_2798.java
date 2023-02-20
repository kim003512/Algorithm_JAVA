package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798 {
    static int N, M = Integer.MIN_VALUE;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<cards.length; i++) {
            for(int j=i+1; j<cards.length; j++) {
                for(int k=j+1; k<cards.length; k++) {
                    int num = cards[i] + cards[j] + cards[k];
                    if(num <= M) {
                        if(num > max) max = num;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int solution2(int[] arr, int N, int M) {
        int max = 0;

        /*
         * 세 수를 더하기 전에 최대값을 넘으면 더 이상 할 필요가 없음
         */
        for(int i=0; i<N-2; i++) {
            if(cards[i] > M) continue;

            for(int j=i+1; j<N-1; j++) {
                if(cards[i] + cards[j] > M) continue;

                for(int k=j+1; k<N; k++) {
                    int num = cards[i] + cards[j] + cards[k];

                    if(num == M) return num;

                    if(max < num && num < M) max = num;
                }
            }
        }
        return max;
    }
}
