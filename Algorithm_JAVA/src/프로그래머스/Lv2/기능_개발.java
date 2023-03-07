package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능_개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] work = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            work[i] = (100-progresses[i]) / speeds[i];

            if((100-progresses[i]) % speeds[i] != 0) {
                work[i] += 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        int x = work[0];
        int cnt = 1;
        for(int i=1; i<progresses.length; i++) {
            if(x >= work[i]) cnt+=1;
            else {
                list.add(cnt);
                cnt = 1;
                x = work[i];
            }
        }
        list.add(cnt);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if(!queue.isEmpty() && queue.peek() < date) {
                answerList.add(queue.size());
                queue.clear();
            }
            queue.offer(date);
        }

        answerList.add(queue.size());

        int[] answer = new int[answerList.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
