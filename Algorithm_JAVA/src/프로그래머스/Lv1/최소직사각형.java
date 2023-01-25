package 프로그래머스.Lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/86491

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int MAX = 0, MIN = 0;

        for(int[] size : sizes) {
            MAX = Math.max(MAX, Math.max(size[0], size[1]));
            MIN = Math.max(MIN, Math.min(size[0], size[1]));
        }
        // for(int i=0; i<sizes.length; i++) {
        //     int[] size = sizes[i];

        //     int max = Math.max(size[0], size[1]);
        //     int min = Math.min(size[0], size[1]);  
            
        //     MAX = Math.max(max, MAX);
        //     MIN = Math.max(min, MIN);
        // }
        return MAX * MIN;
    }
}
