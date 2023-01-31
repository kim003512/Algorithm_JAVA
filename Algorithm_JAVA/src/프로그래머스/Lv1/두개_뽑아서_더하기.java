package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers = {0,3,7,2};
        System.out.println(solution(numbers));
    } 

    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<=numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
               if(!(list.contains(numbers[i] + numbers[j]))) {
                    list.add(numbers[i] + numbers[j]);
               }
            }
        }

        int[] answer = new int[list.size()];
        int n = 0;
        for(int i : list) {
            answer[n++] = i;
        }

        Arrays.sort(answer);

        return answer;
    }
}
