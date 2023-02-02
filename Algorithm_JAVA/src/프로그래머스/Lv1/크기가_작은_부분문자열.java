package 프로그래머스.Lv1;

public class 크기가_작은_부분문자열 {
    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";

        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        for(int i=0; i<=t.length()-p.length(); i++) {
            /*
             * 범위 확인 
             * 테케 중 int 값의 범위를 넘는 경우가 있다 => Long으로
             */
            if(Long.parseLong(t.substring(i, i+p.length())) <= Long.parseLong(p)) 
                answer++;
        }
        return answer;
    }
}
