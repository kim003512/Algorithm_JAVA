package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_10816 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, m; 
    static String[] arr1, arr2;
    public static void main(String[] args) throws IOException {
        useMap();
    }

    public static void useMap() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        sb = new StringBuilder();

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (map.containsKey(num)) {
                sb.append(map.get(num)+ " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.print(sb);
    }

    //시간초과
    public static void useSort() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr1 = new String[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr1[i] = st.nextToken();
        }

        Arrays.sort(arr1);

        m = Integer.parseInt(br.readLine());
        arr2 = new String[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++) {
            arr2[i] = st.nextToken();
        }

        sb = new StringBuilder();
        for(String i : arr2) {
            sb.append(Collections.frequency(Arrays.asList(arr1), i)).append(" ");
        }

        System.out.println(sb);
    }

    public static void userBinary() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr1 = new String[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr1[i] = st.nextToken();
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++) {
            BinarySearch(arr1, Integer.parseInt(st.nextToken()));
        }
    }

    static void BinarySearch(String[] arr, int num) {
        int low = 0;
        int high = arr.length -1;
        int mid;
        while(low<=high){
            mid = (low + high) / 2;
        }
    }
}
