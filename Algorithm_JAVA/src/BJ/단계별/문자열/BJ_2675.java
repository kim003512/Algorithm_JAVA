package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        /**
         * 방법1. 입력값을 char[]에 담아 해당 수 만큼 append
         * 시간 : 120ms
         */
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<n; j++) {
                    sb.append(arr[i]);
                }
            }
            sb.append('\n');
        }

        /**
         * 입력 값을 바로 받아들여와 해당 수 만큼 append
         * 시간 : 120ms
         */
        while(t-- >0) {
            String[] input = br.readLine().split(" ");

            for(byte val : input[1].getBytes()) {
                for(int i=0; i<Integer.parseInt(input[0]); i++) {
                    sb.append((char)val);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
