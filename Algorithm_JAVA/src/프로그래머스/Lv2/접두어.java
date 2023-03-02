package 프로그래머스.Lv2;

import java.util.Arrays;

public class 접두어 {
    public static void main(String[] args) {
        String[] phone_book = { "12", "123", "1235", "567", "88" };

        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                // if (phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())))
                // {
                // answer = false;
                // return answer;
                // }
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }

    public static boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }
}
