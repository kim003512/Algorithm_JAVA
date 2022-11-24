package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

            if(alphabet[now-'a'] == -1) alphabet[now-'a'] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int alpha : alphabet) {
            sb.append(alpha).append(' ');
        }

        System.out.print(sb);
    }
}
