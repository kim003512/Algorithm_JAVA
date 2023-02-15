package 프로그래머스.Lv2;

public class 문자열_압축 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    public static int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++) {
            int splitCnt = 1;
            String splitStr = "";
            String firstStr = s.substring(0, i);

            for(int j = i; j<=s.length(); j+=i) {
                String nextStr = s.substring(j, j+i>s.length() ? s.length() : i+j);
                if(firstStr.equals(nextStr)) splitCnt++;
                else {
                    splitStr += (splitCnt == 1 ? "" : splitCnt) + firstStr;
                    firstStr = nextStr;
                    splitCnt = 1;
                }
            }

            splitStr += firstStr;
            answer = Math.min(answer, splitStr.length());
        }

        return answer;
    }
}
