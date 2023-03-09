package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;

        System.out.println(solution2(scoville, K));
    }

    /*
     * K는 0 이상 1,000,000,000 이하
     * 효율성 x
     */
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        List<Integer> sortList = new ArrayList<>();
        for (int sco : scoville) {
            sortList.add(sco);
        }

        while (true) {
            Collections.sort(sortList);

            // 가장 작은 값이 K보다 크면 다 K보다 큼
            if (sortList.get(0) > K)
                break;
            else if (sortList.size() <= 1)
                break;
            else {
                answer++;
                int a = sortList.get(0);
                int b = sortList.get(1);
                sortList.remove(Integer.valueOf(a));
                sortList.remove(Integer.valueOf(b));
                sortList.add(a + (b * 2));
            }
        }

        return (sortList.size() == 1) ? -1 : answer;
    }

    public static int solution2(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int sco : scoville) {
            queue.add(sco);
        }

        while (true) {
            if (queue.size() == 1 && queue.peek() >= K)
                return answer;
            if (queue.size() == 1)
                return -1;
            if(queue.peek() >= K)
                break;
            answer++;
            queue.add(queue.poll() + queue.poll() * 2);
        }

        // 2번째 방법
        while(queue.size() > 1 && queue.peek() < K) {
            queue.add(queue.poll() + queue.poll()*2);
            answer++;
        }
        if(queue.size() <= 1 && queue.peek() < K) answer = -1;

        return answer;
    }
}