package BJ.단계별.기본_수학_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 120ms
 */
public class BJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[15][15]; //범위 1~14
        for(int i=0; i<15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        for(int i=1; i<15; i++) {
            for(int j=2; j<15; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n]).append('\n');
        }

        System.out.print(sb);
    }
}
