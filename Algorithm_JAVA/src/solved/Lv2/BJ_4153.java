package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_4153 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> arr = new ArrayList<>();

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (x == 0 & y == 0 & z == 0) break;

            arr.add(x);
            arr.add(y);
            arr.add(z);

            Collections.sort(arr);

            if(Math.pow(arr.get(0), 2) + Math.pow(arr.get(1), 2) == Math.pow(arr.get(2), 2)) {
                sb.append("right").append('\n');
            } else{
                sb.append("wrong").append('\n');
            }
        }
        System.out.print(sb);
    }
}
