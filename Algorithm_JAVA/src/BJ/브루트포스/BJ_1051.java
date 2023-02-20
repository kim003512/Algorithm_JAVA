package BJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1051 {
    static int N, M = Integer.MIN_VALUE;
    static int[][] arr = new int[N][M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

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

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2차원 배열 값 넣기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
    }

    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] charArr = new char[N][M];

        for (int i = 0; i < N; i++) {
            charArr[i] = br.readLine().toCharArray();
        }
    }
}
