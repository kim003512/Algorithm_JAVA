package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        /*
        방법 1. trim() -> 빈 문자열인지 확인 
         * split()을 사용할 경우, "  "을 입력 받아 .trim()이나 .strip() 이용하면 => ""(빈 문자열)을 반환
         * ""(빈문자열=빈 문자열을 갖는 문자열)과 null(할당 자체가 되지 않음)은 다르다
         * 
         * 이 경우, trim() 이나 strip()을 통해 양쪽 공백을 제거 후, 
         * 빈 문자열 이라면 -> 0 or 그 외는 split() 함수를 통해 stiring[]의 length
         * 
         * 시간 : 292ms
         */
        String input = br.readLine().trim();

        System.out.print(input.isEmpty() ? "0" : input.split(" ").length);

        /**
         방법 2. StringTokenizer
         시간 : 256ms
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.print(st.countTokens());
    }
}
