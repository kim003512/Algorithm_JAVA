import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 명예의_전당_1 {
    public static void main(String[] args) {
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution3(3, score)));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int min = 0;
            if (list.size() < k) {
                list.add(score[i]);
                min = Collections.min(list);
                answer[i] = min;
            } else {
                min = Collections.min(list);
                if (min < score[i]) {
                    list.remove(Integer.valueOf(min));
                    list.add(score[i]);
                    answer[i] = Collections.min(list);
                } else {
                    answer[i] = min;
                }
            }

            System.out.println(i + " " + Arrays.toString(answer));
        }
        return answer;
    }

    public static int[] solution2(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<score.length; i++) {
            priorityQueue.add(score[i]);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }

        return answer;
    }

    //?????????????
    public static int[] solution3(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<score.length; i++) {
            if(i<k-1) {
                list.add(score[i]);
                System.out.println(list.toString());
                list.sort(Collections.reverseOrder()); //내림차순 정렬
                answer[i] = list.get(list.size() - 1); //정렬 후 맨 마지막 = 제일 작은 값
            } else if(i >= k-1) { 
                list.add(score[i]);
                System.out.println(list.toString());
                list.sort(Collections.reverseOrder());
                answer[i] = list.get(k-1);
            }
        }

        return answer;
    }
}
