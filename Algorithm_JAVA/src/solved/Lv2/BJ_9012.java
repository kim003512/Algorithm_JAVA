package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<Character>();

            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else {
                    if(stack.isEmpty()) {
                        stack.push(str.charAt(j));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
