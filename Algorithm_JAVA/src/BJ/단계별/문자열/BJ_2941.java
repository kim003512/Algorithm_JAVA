package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 각 입력별로 조건을 확인 (len을 확인하는 이유는 StringIndexOutOfBoundsException 방지를 위함)
 * 시간 : 124ms
 */
public class BJ_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int len = input.length();
        int cnt = 0;

        for(int i=0; i<len; i++) {
            char ch = input.charAt(i); 
            
            if(ch == 'c' && i<len-1) {
                if(input.charAt(i+1)=='=' || input.charAt(i+1)=='-') {
                    i++;
                }
            }

            else if(ch =='d' && i<len-1) {
                if(input.charAt(i+1) == '-') {
                    i++;
                } else if(input.charAt(i+1) == 'z' && i<len-2) {
                    if(input.charAt(i+2) == '=') {
                        i += 2;
                    }
                }
            }

            else if((ch=='l' || ch=='n') && i<len-1) {
                if(input.charAt(i+1) == 'j') {
                    i++;
                }
            }

            else if((ch=='s' || ch=='z') && i<len-1) {
                if(input.charAt(i+1) == '=') {
                    i++;
                }
            }

            cnt++;
        }

        System.out.print(cnt);
    }
}
