package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(minHeap.isEmpty()) sb.append(0).append('\n');
                else sb.append(minHeap.poll()).append('\n');
            } else {
                minHeap.add(num);
            }
        }

        System.out.println(sb);
    }
}
