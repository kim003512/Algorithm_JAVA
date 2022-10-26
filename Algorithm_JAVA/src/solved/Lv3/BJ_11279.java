package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_11279 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if (maxheap.isEmpty()) sb.append(0).append('\n');
                else sb.append(maxheap.poll()).append('\n');
            } else {
                maxheap.add(num);
            }
        }
        System.out.println(sb);
    }
}
