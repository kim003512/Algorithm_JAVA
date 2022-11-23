package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_11723 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> arr = new HashSet<>();

        StringTokenizer st;
        int num = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            switch(str) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    arr.add(num);
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    arr.remove(num);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    System.out.println(arr.contains(num) ? 1 : 0);
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    if(arr.contains(num)) {
                        arr.remove(Integer.valueOf(num));
                    } else {
                        arr.add(num);
                    }
                    break;
                case " all" :
                    arr.clear();
                    for(int j=1; j<=20; j++) {
                        arr.add(i);
                    }
                case "empty" :
                    arr.clear();
                    break;
            }
        }
    }
}
