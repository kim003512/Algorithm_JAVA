package 프로그래머스.Lv1;

import java.util.Arrays;

public class k번째수 {
    public static void main(String args[]) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        System.out.println(solution(array, commands).toString());
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] cutArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cutArr);

            answer[i] = cutArr[commands[i][2]-1];
        }

        return answer;
    }
}
