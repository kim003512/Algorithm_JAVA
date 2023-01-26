package 프로그래머스.Lv1;

public class 삼총사 {
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(solution(number));
    }

    /*
     * 브루트포스 ? - 모든 값을 비교하며 조건에 맞다면 ++
     * 하지만, for문 3번 -> 시간적 낭비가 크다?
     */
    public static int solution(int[] number) {
        int answer = 0;

        for(int i=0; i<number.length; i++) {
            for(int j=i+1; j<number.length; j++) {
                for(int k=j+1; k<number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }
}
