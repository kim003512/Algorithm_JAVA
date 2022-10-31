package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int prev_end_time = arr[0][1];
        int cnt = 1;

        for(int i=1; i<arr.length; i++) {
            if(prev_end_time <= arr[i][0]) {
                prev_end_time = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
