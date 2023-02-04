package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 수포자 {
    static int[] one = {1,2,3,4,5};
    static int[] two = {2,1,2,3,2,4,2,5};
    static int[] three = {3,3,1,1,2,2,4,4,5,5};
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        System.out.println(solution2(answers));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        Map<Integer, int[]> list = new HashMap<Integer, int[]>();
        int[] score = {0, 0, 0};

        list.put(1, one);
        list.put(2, two);
        list.put(3, three);

        for(int i=0; i<3; i++) {
            for(int j=0; j<answers.length; j++) {
                if(j > list.get(i).length) j = 0;

                //if(answers[j] == list.get(i))
            }
        }

        return answer;
    }

    public static int[] solution2(int[] answers) {
        int[] score = {0, 0, 0};

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) score[0]++;
            if(answers[i] == two[i%8]) score[1]++;
            if(answers[i] == three[i%10]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> maxList = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) if(max == score[i]) maxList.add(i+1);
        

        int[] answer = new int[maxList.size()];
        for(int i=0; i<answer.length; i++) answer[i] = maxList.get(i);
        
        return answer;
    }
}
