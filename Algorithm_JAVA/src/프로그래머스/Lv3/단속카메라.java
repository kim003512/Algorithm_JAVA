package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int answer = 0;

        /*
         * 맨 처음의 나가는 시점을 기준으로
         * 
         * => 정렬이 필요함
         */
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2) {
                /*
                 * 1. 배열의 0번째 위치 비교
                 * 2. 해당 배열의 위치가 같다면
                 * 3. 오름차순 정렬
                 * 
                 * cf) 내림차순 정렬 = return a1[0] - a2[0]
                 */
                return (a1[0] == a2[0]) ? a1[1] - a2[1] : a1[0] - a2[0];
            }
        });

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cam = -30000; //진입 시작 시점
        for(int[] r : routes) {
            if(cam < r[0]) {
                cam = r[1];
                answer++;
            }
        }

        return answer;
    }
}
