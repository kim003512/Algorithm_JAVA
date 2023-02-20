package 프로그래머스.Lv2;

import java.util.HashSet;

public class 소수_찾기 {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];

        // recursion("", 0);
        permutation("", numbers, set);

        return set.size();
    }

    // 조합 가능한 숫자 & 소수 판별
    public static void recursion(String str, int idx) {
        int num;

        if (str != "") {
            num = Integer.parseInt(str);

            if (isPrime(num))
                set.add(num);
        }

        if (idx == arr.length)
            return;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            recursion(str + arr[i], idx + 1);
            visited[i] = false;
        }
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.equals("")) {
            if (isPrime(Integer.parseInt(prefix)))
                set.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < n; i++) {
            System.out.println(" 1 = " + prefix + str.charAt(i));
            System.out.println(" 2 = " + str.substring(0, i) + str.substring(i + 1, n));
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
