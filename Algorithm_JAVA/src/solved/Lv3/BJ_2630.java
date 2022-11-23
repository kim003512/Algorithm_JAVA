package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2630 {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr= new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);

        System.out.println(white + "\n" + blue);
    }

    private static void solve(int row, int col, int size) {
        if(checkColor(row, col, size)) {
            if(arr[row][col] == 0) white++;
            else blue++;

            return;
        }

        int newSize = size / 2;

        solve(row, col, newSize);
        solve(row+newSize, col, newSize);
        solve(row, col+newSize, newSize);
        solve(row+newSize, col+newSize, newSize);
    }

    private static boolean checkColor(int row, int col, int size) {
        int color = arr[row][col]; // 첫번째 원소 기준으로 같은지 확인

        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(arr[i][j] != color) return false;
            }
        }

        return true; //모두 통과 = 모두 같은 색이므로 true
    }
}
