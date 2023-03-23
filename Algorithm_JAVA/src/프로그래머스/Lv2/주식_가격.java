package 프로그래머스.Lv2;

import java.io.IOException;
import java.util.Arrays;

public class 주식_가격 {
    public static void main(String[] args) throws IOException {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution2(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++) {
            int count = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] <= prices[j]) count++;
                else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        answer[prices.length-1] = 0;
        return answer;
    }

    public static int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
