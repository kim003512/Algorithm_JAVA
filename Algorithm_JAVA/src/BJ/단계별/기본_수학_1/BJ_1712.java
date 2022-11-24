package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 120ms
 */
public class BJ_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);

        int result = 0;

        /*
         * C-B < 0 => by zero(런타임 에러)
         */
        if(B>=C) result = -1;
        else {
            result = (A / (C-B) + 1);
        }

        System.out.print(result);
    }
}
