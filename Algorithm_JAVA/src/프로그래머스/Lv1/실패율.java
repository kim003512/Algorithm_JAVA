package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 실패율 {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(5, stages));
    }   

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Double> failMap = new HashMap<Integer, Double>();
        //각 스테이지별 실패율 계산
        for(int i=1; i<=N; i++) {
            double fail = 0;

            int top = 0;
            int floor = 0;
            for(int j=0; j<stages.length; j++) {
                if(i == stages[j]) top++;
                if(i <= stages[j]) floor++; 
            }
            fail = (double)top / (double)floor; //각 타입을 double로 해야 0.0의 결과가 나오지 않음
            
            failMap.put(i, fail);
        }
        
        //정렬
        List<Integer> key = new ArrayList<Integer>(failMap.keySet());
        Collections.sort(key, (o1, o2) -> (failMap.get(o2).compareTo(failMap.get(o1))));

        for(int i=0; i<N; i++) {
            answer[i] = key.get(i);
        }
        
        return answer;
    }
}
