package BJ.단계별.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];
        for(int i=0; i<2; i++) {
            for(int a=0; a<n; a++) {
                st = new StringTokenizer(br.readLine());
                for(int b=0; b<m; b++) {
                    A[a][b] += Integer.parseInt(st.nextToken());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
