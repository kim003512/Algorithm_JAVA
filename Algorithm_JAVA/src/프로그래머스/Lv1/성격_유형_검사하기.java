package 프로그래머스.Lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };

        System.out.println(solution(survey, choices));
    }

    // 개노답 코드
    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String ch1 = Character.toString(survey[i].charAt(0));
            String ch2 = Character.toString(survey[i].charAt(1));
            int num1 = map.get(ch1);
            int num2 = map.get(ch2);

            if (choices[i] == 1 || choices[i] == 2 || choices[i] == 3) {
                switch (choices[i]) {
                    case 1:
                        map.replace(ch1, num1 + 3);
                        break;
                    case 2:
                        map.replace(ch1, num1 + 2);
                        break;
                    case 3:
                        map.replace(ch1, num1 + 1);
                        break;
                }
            } else if (choices[i] == 5 || choices[i] == 6 || choices[i] == 7) {
                switch (choices[i]) {
                    case 5:
                        map.replace(ch2, num2 + 1);
                        break;
                    case 6:
                        map.replace(ch2, num2 + 2);
                        break;
                    case 7:
                        map.replace(ch2, num2 + 3);
                        break;
                }
            }
        }

        answer.append((map.get("R") >= map.get("T") ? "R" : "T"));
        answer.append((map.get("C") >= map.get("F") ? "C" : "F"));
        answer.append((map.get("J") >= map.get("M") ? "J" : "M"));
        answer.append((map.get("A") >= map.get("N") ? "A" : "N"));

        return answer.toString();
    }

    public static String solution2(String[] survey, int[] choices) {
        String answer = "";

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
            } else if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            }
        }

        if (map.get('R') >= map.get('T'))
            answer = "R";
        else
            answer = "T";

        if (map.get('C') >= map.get('F'))
            answer += "C";
        else
            answer += "F";

        if (map.get('J') >= map.get('M'))
            answer += "J";
        else
            answer += "M";

        if (map.get('A') >= map.get('N'))
            answer += "A";
        else
            answer += "N";

        return answer;
    }
}
