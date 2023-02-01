package 프로그래머스.Lv1;

public class two016년 {
    //윤년
    static int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
    
    //시작 = 금요일
    static String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    public static void main(String[] args) {
        System.out.println(solution(2, 1));
    }

    public static String solution(int a, int b) {
        int beforeDay = -1; //0-365일

        for(int i=0; i<a-1; i++) { //구하려는 전 달의 일수까지만 더함
            beforeDay += months[i];
        }

        return days[(beforeDay+b) % 7];
    } 
}
