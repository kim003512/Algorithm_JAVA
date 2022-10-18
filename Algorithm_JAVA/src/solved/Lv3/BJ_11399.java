package solved.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int num = 0;
        int sum = 0;
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=0; j<=i; j++) {
        //         num += arr[j];
        //     }
        // }

        for(int i=0; i<n; i++) {
            sum += num + arr[i];
            num += arr[i];
        }
        System.out.println(sum);
    }
}
