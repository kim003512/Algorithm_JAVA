package solved.Lv3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_1764 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> setA = new HashSet<String>();
        for(int i=0; i<n; i++) {
            setA.add(br.readLine());
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<m; i++) {
            String str = br.readLine();
            if(setA.contains(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(String s : result) {
            System.out.println(s);
        }
    }
}
