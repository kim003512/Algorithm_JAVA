package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int zero, one;
        for(int i=0; i<3; i++) {
            zero = one = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                int nowNum = Integer.parseInt(st.nextToken()); 
                if (nowNum == 0) zero++;
                else if (nowNum == 1) one++;
            }

            if(zero == 1 && one == 3) sb.append('A').append('\n');
            if(zero == 2 && one == 2) sb.append('B').append('\n');
            if(zero == 3 && one == 1) sb.append('C').append('\n');
            if(zero == 0 && one == 4) sb.append('D').append('\n');
        }

        System.out.print(sb);
    }
}
