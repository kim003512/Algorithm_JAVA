package 프로그래머스.Lv1;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class 문자열_나누기 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("hello"));
    }

    public static int solution(String s) {
        char x = s.charAt(0);
        int isX = 1;
        int notX = 0;
        int answer = 0;

        char ch;

        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);

            if (x == ch)
                isX++;
            else
                notX++;

            if (isX == notX) {
                x = s.charAt(i + 1);
                System.out.println(x);
                isX = 1;
                notX = 0;
                answer++;
            }
        }

        int idx = 1;
        for (char c : s.toCharArray()) {
            if (x == c)
                isX++;
            else
                notX++;

            if (isX == notX) {
                idx++;

            } else
                idx++;
        }

        return answer;
    }

    public static int solution2(String s) {
        int answer = 0;

        while (s.length() != 0) {
            answer++;

            char ch = s.charAt(0);

            int isX = 1;
            int notX = 0;

            for (int i = 1; i < s.length(); i++) {
                if (ch == s.charAt(i))
                    isX++;
                else
                    notX++;

                if (isX == notX)
                    break;
            }

            s = s.substring(isX + notX);
        }

        return answer;
    }
}
