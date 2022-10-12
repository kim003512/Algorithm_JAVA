package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ_1920 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 사용되지 않음
        Set<Integer> set = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toSet());

        br.readLine(); // 사용되지 않음

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).map(i -> set.contains(i) ? 1 : 0)
                .forEach(System.out::println);
    }

    // 시간 초과
    public static void anyMatch() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : arr2) {
            if (Arrays.stream(arr1).anyMatch((num::equals))) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.print(sb);
    }
}
