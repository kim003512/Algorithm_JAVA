package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Collections;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", " car"};
        System.out.println(solution(strings, 1));
    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(arr); //오름차순 정렬

        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }

        return answer;
    }
}
