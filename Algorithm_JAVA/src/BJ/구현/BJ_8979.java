package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][3];

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            int nation = Integer.parseInt(str[0]);
            arr[nation][0] = Integer.parseInt(str[1]);
            arr[nation][1] = Integer.parseInt(str[2]);
            arr[nation][2] = Integer.parseInt(str[3]);
        }

        int rank = 1;

        for(int i=1; i<=n; i++) {
            if(arr[i][0] > arr[k][0]) rank++;
            else if(arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) rank++;
            else if(arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) rank++;
        }

        System.out.println(rank);
    }
}
