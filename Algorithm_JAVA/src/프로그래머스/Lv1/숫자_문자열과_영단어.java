package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자_문자열과_영단어 {
    static String[] alpha = {"zero", "one", "two", "three", "four", "five","six", "seven", "eight", "nine"};
    static String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static void main(String[] args) {
        System.out.println(solution("2three45sixseven"));
    }

    public static int solution(String s) {
        String[] arr = s.split("");

        List<String> strList = new ArrayList<>(Arrays.asList(alpha));
        String str = "";
        String nowStr = "";
        for(String c : arr) {
            if('0' <= c.charAt(0)&& c.charAt(0) <= '9') str += c;
            else {
                nowStr += c;
                if(strList.contains(nowStr)) {
                    str += num[Arrays.asList(alpha).indexOf(nowStr)];
                    nowStr = "";
                } else continue;
            }
        }

        return Integer.parseInt(str);
    }

    public static int solution2(String s) {
        for(int i=0; i<10; i++) {
            s = s.replace(alpha[i], num[i]);
        }

        return Integer.parseInt(s);
    }
}
