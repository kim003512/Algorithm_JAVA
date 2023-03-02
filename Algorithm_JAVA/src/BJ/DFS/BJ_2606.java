package BJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2606 {
    static int answer = 0;
    static int comNum, connectNum;
    static int[][] connectArr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comNum = Integer.parseInt(br.readLine());
        connectNum = Integer.parseInt(br.readLine());
        connectArr = new int[comNum+1][comNum+1];
        visited = new boolean[comNum+1];
        
        for(int i=0; i<connectNum; i++) {
            String[] str = br.readLine().split(" ");
            connectArr[Integer.parseInt(str[0])][Integer.parseInt(str[1])]
            = connectArr[Integer.parseInt(str[1])][Integer.parseInt(str[0])]
            = 1;
        }

        dfs_stack(1);
        System.out.println(answer);
    }

    public static void dfs_stack(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while(!stack.isEmpty()) {
            int num = stack.pop();
            visited[num] = true;
            
            for(int i=1; i<=comNum; i++) {
                if(!visited[i] && connectArr[num][i] == 1) {
                    stack.push(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
    }

    public static void dfs_recursion(int v) {
        visited[v] = true;

        for(int i=1; i<=comNum; i++) {
            if(!visited[i] && connectArr[v][i] == 1) {
                answer++;
                dfs_recursion(i);
            }
        }
    }
}
