package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 둘만의_암호 {
    public static void main(String[] args) {
        System.out.println(solution2("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        for(char c : skip.toCharArray()) list.add(c);

        System.out.println(list.toString());
        Stack<Character> stack;
        for(char c : s.toCharArray()) {
            stack = new Stack<>();

            while(true) {
                if(stack.size() == index) break;
                c++;
                if(c > 'z') c = 'a';

                if(!list.contains(c)) {
                    stack.push(c);
                }
                
            }

            answer += stack.peek(); 
        }

        return answer;
    }

    public static String solution2(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()) {
            char temp = c;
            int idx = 0;

            while(idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp+1);

                if(!skip.contains(String.valueOf(temp))) idx += 1;
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}
