package solved.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1259 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringBuilder sb2;
    static StringTokenizer st;
    static List<Character> que;
    public static void main(String[] args) throws IOException {
        useCharAt();
    }

    public static void useCharAt() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            boolean check = true;

            if(str.equals("0")) break;

            for(int i=0; i<str.length()/2; i++) {
                System.out.println(str.charAt(i)+" "+str.charAt(str.length() -1 -i));
                if (str.charAt(i) != str.charAt(str.length() -1 -i)) check = false;
            }

            if(check) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void useStringBuilder() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            que = new ArrayList<>();
            String num = br.readLine();
            if(num.equals("0")) break;
            
            st = new StringTokenizer(num, "");
            char[] str = num.toCharArray();
            for(char c : str) {
                que.add(c);
            }

            sb = new StringBuilder();
            for(int i=0; i<que.size(); i++) {
                sb.append(que.get(i));
            }

            sb2 = new StringBuilder();
            for(int i=que.size()-1; i>=0; i--) {
                sb2.append(que.get(i));
            }

            System.out.println((sb.toString().equals(sb2.toString()))? "yes" : "no");
        }
    }
}
