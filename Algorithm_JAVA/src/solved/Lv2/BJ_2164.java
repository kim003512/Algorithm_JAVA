package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<n; i++) {
            que.add(i+1);
        }
    
        while(que.size() != 1) {
            que.remove();
            que.add(que.peek());
            que.remove();
        }

        System.out.println(que.peek());
    }
}
