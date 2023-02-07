package 프로그래머스.Lv1;

import java.util.Arrays;

public class 과일장수 {
    public static void main(String[] args) {
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution2(3, 4, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int idx = score.length-1;
        while(true) {
            if(idx < 0) break;
            else {
                System.out.println(idx);
                int[] arr = (idx-m < 0) ? Arrays.copyOfRange(score, 0, idx) : Arrays.copyOfRange(score, idx-m+1, idx);
                System.out.println(Arrays.toString(arr));
                answer += arr[0] * m;
                idx -= m;
            }
            
        }

        return answer;
    }

    public static int solution2(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        
        for(int i=score.length % m; i<score.length; i += m) {
            answer += score[i];
        }

        return answer * m;
    }
}
