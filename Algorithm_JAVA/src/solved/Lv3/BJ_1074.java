package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074 {
    static int N, R, C, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        R = Integer.parseInt(str[1]);
        C = Integer.parseInt(str[2]);

        solve(0, 0, (int) Math.pow(2, N));
    }   

    public static void solve(int x, int y, int size) {
        if(size == 1) {
            System.out.println(ans);
            return;
        }

        int reSize = size / 2;

        if(x+reSize > R && y+reSize > C) {//1사분면 
            solve(x, y, reSize);
        }
        if(x+reSize>R && y+reSize<=C){//2사분면
            ans += (size*size) / 4;
            solve(x, y+reSize, reSize);
        } 
        if(x+reSize<=R && y+reSize>C){ //3사분면 
            ans += ((size*size) / 4) * 2;
            solve(x+reSize, y, reSize);
        }
        if(x+reSize <=R && y+reSize<=C){//4사분면
            ans += ((size*size) / 4) * 3;
            solve(x+reSize, y+reSize, reSize);
        } 
    }
}
