package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(Integer N : arr) {
            sb.append(N).append('\n');
        }

        System.out.print(sb);

        /** 
        for(Integer N : arr) {
            System.out.println(N);
        } 출력 방식 시간 초과 */


        // Arrays.sort(arr); 시간 초과
    }
}
