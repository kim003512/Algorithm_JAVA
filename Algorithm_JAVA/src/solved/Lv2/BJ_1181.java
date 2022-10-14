package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class BJ_1181 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }
        String[] arr = new String[set.size()];
        set.toArray(arr);

        //Arrays.sort(arr, Comparator.comparing(String::length));
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        for(int i=0; i<arr.length; i++) {
            if (i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
