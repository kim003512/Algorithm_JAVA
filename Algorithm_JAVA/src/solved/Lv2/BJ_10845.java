package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class BJ_10845 {
    static int[] queue = new int[10001];
    static int first = 0;
    static int last = 0;
    public static void main(String[] args) throws IOException {
        useQueue();
    }

    public static void push(int x) {
        queue[first] = x;
        last++;
    }
    public static int pop(){
        if(last - first == 0) return -1;
        else {
            int p = queue[first];
            first++;
            return p;
        }
    }
    public static int size(){
        return last - first;
    }
    public static int empty(){
        if (last - first == 0) return -1;
        else return 0;
    }
    public static int front() {
        if(last-first == 0) return -1;
        else return queue[first];
    }
    public static int back() {
        if(last-first == 0) return -1;
        else return queue[last-1];
    }

    public static void useQueue() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            switch(str) {
                case "push" :
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                    break;
                case "pop" :
                    if(queue.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(queue.peek()).append('\n');
                        queue.remove();
                    }
                    break;
                case "size" :
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front" :
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back" :
                    sb.append(queue.isEmpty() ? -1 : last).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
