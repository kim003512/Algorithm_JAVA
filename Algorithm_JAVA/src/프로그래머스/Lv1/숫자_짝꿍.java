package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자_짝꿍 {
    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
    }

    //런타임 에러 & 시간 초과
    public static String solution(String X, String Y) {
        List<Integer> answerList = new ArrayList<>();

        List<String> yList = new ArrayList<>();
        for(char c : Y.toCharArray()) {
            yList.add(Character.toString(c));
        }

        for(char c : X.toCharArray()) {
            if(yList.contains(Character.toString(c))) {
                yList.remove(Character.toString(c));
                answerList.add(c-'0');
            }
        }

        Collections.sort(answerList, Collections.reverseOrder());
        
        String answer = "";
        for(Integer i : answerList) {
            answer += i;
        }
        
        if (answer.length() == 0) return "-1"; 
        else if(Integer.parseInt(answer) == 0) return "0";
        else return answer;
    }

    public static String solution2(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i=0; i<X.length(); i++) {
            x[X.charAt(i) - '0'] += 1;
        }
        for(int i=0; i<Y.length(); i++) {
            y[Y.charAt(i) - '0'] += 1;
        }

        for(int i=9; i>=0; i--) {
            for(int j=0; j<Math.min(x[i], y[i]); j++) {
                answer.append(i);
            }
        }

        if("".equals(answer.toString())) return "-1";
        else if(answer.toString().charAt(0) == 48) return "0";
        else return answer.toString();
    }
}
