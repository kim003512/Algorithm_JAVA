package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 124ms
 */
public class BJ_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int sum = 0;
        for(char c : input) {
            if(c>='A' && c<='C') sum +=3;
            else if(c>='D' && c<='F') sum +=4;
            else if(c>='G' && c<='I') sum+=5;
            else if(c>='J' && c<='L') sum+=6;
            else if(c>='M' && c<='O') sum+=7;
            else if(c>='P' && c<='S') sum+=8;
            else if(c>='T' && c<='V') sum+=9;
            else if(c>='W' && c<='Z') sum+=10;
        }

        System.out.print(sum);
    }
}
