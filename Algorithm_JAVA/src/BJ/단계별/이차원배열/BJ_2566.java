package BJ.단계별.이차원배열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2566 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(x+1).append(' ').append(y+1);

        System.out.print(sb);
    }
}
