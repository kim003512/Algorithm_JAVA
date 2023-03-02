package 프로그래머스.Lv2;

public class 타겟_넘버 {
    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;
    static int count = 0;
    public static void main(String[] args) {
        dfs(numbers, target, 0, 0);        
        System.out.println(count);
    }

    public static void dfs(int[] numbers, int target, int depth, int result) {
        if(depth == numbers.length) {
            if(target == result) count++;

            return;
        }

        int plus = result + numbers[depth];
        int minus = result - numbers[depth];
        
        dfs(numbers, target, depth+1, plus);
        dfs(numbers, target, depth+1, minus);
    }

    public static int dfs2(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs2(numbers, n+1, sum+numbers[n], target) + dfs2(numbers, n+1, sum-numbers[n], target);
    }
}
