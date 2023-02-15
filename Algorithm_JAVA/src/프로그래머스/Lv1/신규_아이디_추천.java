package 프로그래머스.Lv1;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public static String solution(String new_id) {
        String answer = "";

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        for(char ch : new_id.toCharArray()) {
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9') || (ch == '-') || (ch=='_') || (ch=='.')) {
                answer += ch;
            }
        }

        //3단계
        while(true) {
            if(!answer.contains("..")) break;
            answer = answer.replace("..", ".");
        }

        //4단계
        if(answer.charAt(0) == '.') answer = answer.substring(1);
        if(!answer.isEmpty() && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);

        //5단계
        if(answer.length() == 0) answer = "a";

        //6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 1);
        }

        //7단계
        if(answer.length() <= 2) {
            while(true) {
                if(answer.length() == 3) break;
                answer += answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }

    public static String solution2(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");

        if(answer.equals("")) answer += "a";

        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        if(answer.length() <= 2) {
            while(true) {
                if(answer.length() == 3) break;
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        return answer;
    }
}
