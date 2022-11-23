package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부르트 포스
public class BJ_1018 {
    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void useBool() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    }

    public static void solution() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<m; j++) {
                for(int k=0; k<n; k++) {
                    arr[i][j] = str[k];
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (i == 0) {
                    if(j == 0) {
                        continue;
                    } else {
                        if(arr[i][j-1].equals(arr[i][j])) {
                            cnt++;
                        }
                    }
                } else {
                    if(j != 0) {
                        if(arr[i][j-1].equals(arr[i][j])) {
                            cnt++;
                        }
                    } else {
                        if(arr[i-1][j].equals(arr[i][j])) {
                            cnt ++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
