import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 로또의_최고_순위오_최저_순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCnt = 0;
        List<Integer> lottoList = new ArrayList<>();
        for(int l : lottos) {
            if(l == 0) {
                zeroCnt++;
                continue;
            } else {
                lottoList.add(l);
            }
        }

        int cnt = 0;
        for(int i=0; i<win_nums.length; i++) {
            if(lottoList.contains(win_nums[i])) cnt++;
        }

        answer[0] = getGrage(cnt+zeroCnt);
        answer[1] = getGrage(cnt);

        return answer;
    }

    public static int getGrage(int num) {
        switch(num) {
            case 6 : 
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}
