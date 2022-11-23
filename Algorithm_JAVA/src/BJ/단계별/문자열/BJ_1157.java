package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /*
         * 방법 1. map을 통해 key = 알파벳, value = 빈도
         * 각 key를 돌아가며 max와 비교한다
         * 시간 : 400ms
         */
        Map<Character, Integer> set = new HashMap<>();

        for (char c : br.readLine().toUpperCase().toCharArray()) {
            if (set.containsKey(c)) {
                set.put(c, set.get(c) + 1);
            } else {
                set.put(c, 1);
            }
        }

        int max = 0;
        char c = '?';
        for(Map.Entry<Character, Integer> map : set.entrySet()) {
            if(map.getValue() > max) {
                max = map.getValue();
                c = map.getKey();
            } else if (map.getValue() == max) {
                c = '?';
            }
        }

        System.out.print(c);

        /*
         * 방법 2 : 알파벳 배열(26사이즈)에 각 알파벳 별 빈도수 인덱스로 저장
         * 입력 값을 upper로 받아오기 때문에 일괄적으로 -65
         * 이후 방법은 위와 동일
         * 시간 : 284ms
         */
        int[] alphabet = new int[26];
        String s = br.readLine().toUpperCase();

        for(int i=0; i<s.length(); i++) {
            alphabet[s.charAt(i)-65]++;
        }

        int max2=0;
        char c2 = '?';

        for(int i=0; i<alphabet.length; i++) {
            if(alphabet[i] > max2) {
                max2 = alphabet[i];
                c2 = (char) (i+65);
            } else if (alphabet[i] == max2) {
                c2 = '?';
            }
        }
        System.out.println(c2);
    }
}
