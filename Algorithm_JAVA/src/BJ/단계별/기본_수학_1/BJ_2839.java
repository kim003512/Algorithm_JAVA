package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int cnt = 0;

        /*
         * 방법 1.
         * 시간 : 124ms
         */
        while(true) {
            if(input % 5 ==0) {
                cnt += input/5;
                System.out.print(cnt);
                break;
            } else {
                input -=3;
                cnt++;
            } 
            if(input < 0) {
                System.out.println("-1");
                break;
            }
        }

        /*
         * 방법 2.
         * 시간 : 124ms
         */
        if(input == 4 || input == 7) {
            System.out.print(-1);
        } else if(input % 5 == 0) {
            System.out.print(input / 5);
        } else if(input % 5 == 1 || input % 5 == 3){
            System.out.print((input/5) + 1);
        } else if(input % 5 == 2 || input % 5 == 4){
            System.out.print((input/5) + 2);
        }
    }
}
