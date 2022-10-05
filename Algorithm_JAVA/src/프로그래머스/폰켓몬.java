package 프로그래머스;
import java.util.HashSet;
public class 폰켓몬 {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            numSet.add(num);
        }

        if (numSet.size() > max) {
            return max;
        } else {
            return numSet.size();
        }
    }
}
