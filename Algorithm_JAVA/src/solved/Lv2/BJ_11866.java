package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> queue = new LinkedList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        useQueue();
    } 

    public static void useQueue() throws IOException{
        //System.setIn(new FileInputStream("src/input.txt"));
        st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        sb = new StringBuilder();
        sb.append("<");
        while(queue.size() > 1) {
            for(int i=0; i<k-1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()+", ");
            
            /**if(queue.size() == 1) {
                sb.append(queue.poll()+">");
            } else{
                sb.append(queue.poll()+", ");
            }*/
        }
        sb.append(queue.poll()+">");
        System.out.println(sb);
    }
}
