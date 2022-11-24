package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 124ms
 * now -'a'
 */
public class BJ_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        String str = br.readLine();

        for(int i=0; i<alphabet.length; i++) {
            alphabet[i] = -1;
        }

        for(int i=0; i<str.length(); i++) {
            char now = str.charAt(i);

            /*
             * 같은 문자일 경우 처음 등장하는 위치를 기준으로 하기 때문에
             */
            if(alphabet[now-'a'] == -1) alphabet[now-'a'] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int alpha : alphabet) {
            sb.append(alpha).append(' ');
        }

        System.out.print(sb);
    }
}
