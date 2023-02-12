package 프로그래머스.Lv1;

public class 옹알이2 {
    static String[] check = {"aya", "ye", "woo", "ma"};
    static String[] doubleCheck = {"ayaaya", "yeye", "woowoo", "mama"};
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String b : babbling) {
            for(String dc : doubleCheck) {
                b = b.replace(dc, " ");
            }

            for(String c : check) {
                b = b.replace(c, "?");
            }

            int sign = 0;

            for(int i=0; i<b.length(); i++) {
                if(!b.subSequence(i, i+1).equals("?")) {
                    sign = 1;
                    break;
                }
            }

            if(sign == 0) answer++;
        }

        return answer;
    }
}
