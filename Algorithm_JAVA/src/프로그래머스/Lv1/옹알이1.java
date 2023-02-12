package 프로그래머스.Lv1;

public class 옹알이1 {
    static String[] check = {"aya", "ye", "woo", "ma"};
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};

        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String s : babbling) {
            for(String c : check) {
                s = s.replace(c, " ");
            }

            if(s.replaceAll(" ", "").equals(" ")) {
                answer++;
            }
        }
        return answer;
    }
}
