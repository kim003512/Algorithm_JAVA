package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * BufferedReader를 통해 char -> int
         */
        char input = br.readLine().charAt(0);
        int isalpa = (int)input;

        /**
         * int로 바로 받아오기
         */
        int a = (int) br.readLine().charAt(0);
        /**
         * System.in을 통해 바로 받아오기
         */
        int b = System.in.read();

        System.out.print(b);        
    }   
}
/**
 * https://www.acmicpc.net/problem/11654
 */


/**
 * 아스키 코드 변환
 * 1) 입력 값을 char 값으로 받아온다
 *  - br은 String 값을 가져오기 때문에 charAt(0)을 통해 char로 변환
 * 2) char -> int 형 변환을 통해 아스키 코드로 변환
 */