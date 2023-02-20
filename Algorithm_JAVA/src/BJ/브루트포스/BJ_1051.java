package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        // int len = arr.length;
        int len = Math.min(N, M);
        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    // 범위를 넘는다면 break
                    // if (i + (len - 1) >= arr[i].length || j + (len - 1) >= arr.length)
                    // break;
                    int nowNum = arr[i][j];
                    int rightUp = arr[i][j + (len - 1)];
                    int rightDown = arr[i + (len - 1)][j + (len - 1)];
                    int leftDown = arr[i + (len - 1)][j];

                    if (nowNum == rightUp && nowNum == rightDown && nowNum == leftDown) {
                        System.out.println(len * len);
                        return;
                    }

                }
            }
            len--;
        }
        System.out.println(len * len);
    }
}
