package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_18870 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sorted);

        int idx = 0;

        for(int num : sorted) {
            if(!map.containsKey(num)) {
                map.put(num, idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
