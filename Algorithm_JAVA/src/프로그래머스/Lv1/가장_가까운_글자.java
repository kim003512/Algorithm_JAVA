package 프로그래머스.Lv1;

import java.util.HashMap;

public class 가장_가까운_글자 {
    public static void main(String[] args) {
        System.out.println(solution("banana").toString());
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;

        for (int i = 1; i < s.length(); i++) {
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                cnt++;
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = cnt;
                    break;
                }
                answer[i] = -1;
            }
        }
        return answer;
    }

    public static int[] solution2(String s) {
        HashMap<Character, Integer> alpha = new HashMap<>();
        int[] answer = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(!alpha.containsKey(s.charAt(i))) answer[i] = -1;
            else answer[i] = i - alpha.get(s.charAt(i));
            alpha.put(s.charAt(i), i);
        }

        return answer;
    }

    public static int[] solution3(String s) {
        int[] answer = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(i != 0) {
                /*
                 * lastIndexOf = 오른쪽부터 문자열을 센다
                 */
                int idx = s.substring(0, i).lastIndexOf(s.charAt(i));
                if(idx != -1) answer[i] = i - idx;
                else answer[i] = idx;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
