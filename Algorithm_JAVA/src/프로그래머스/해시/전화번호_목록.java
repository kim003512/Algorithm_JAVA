package 프로그래머스.해시;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        전화번호_목록 sol = new 전화번호_목록();
        System.out.println(sol.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        // for(String phone : phone_book) {
        //     for(int i=0; i<phone_book.length; i++) {
        //         if(phone_book[i].startsWith(phone)) {
        //             System.out.println(phone + " " + phone_book[i]);
        //             break;
        //         }
        //     }
        //     return false;
        // }
        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
    
    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }

    public boolean solution3(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        System.out.println(map);
        // 모든 전화번호의 substring이 hashmap에 존재하는지 확인
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                System.out.println(phone_book[i].substring(0, j));
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
