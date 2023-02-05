package 프로그래머스.Lv1;

public class 푸드파이터_대회 {
    public static void main(String[] args) {
        //food의 0번 인덱스 = 물을 의미
        int[] food = {1, 3, 4, 6};

        System.out.println(solution3(food));
    }

    public static String solution(int[] food) {
        String answer = "";

        //food[0] = 물(무조건 1)
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                answer += Integer.toString(i);
            }
        }

        String reverse = "";
        for(int i=answer.length()-1; i>=0; i--) {
            reverse += answer.charAt(i);
        }

        return answer +"0" + reverse;
    }

    public static String solution2(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                sb.append(i);
            }
        }

        // sb.append(0).append(sb.reverse());

        // return sb.toString();

        return sb.toString() + "0" + sb.reverse().toString();
    }

    public static String solution3(int[] food) {
        String answer ="0";

        for(int i=food.length-1; i>0; i--) {
            System.out.println("i == " + i);
            for(int j=0; j<food[i]/2; j++) {
                answer = i + answer + i;

                System.out.println("answer == " + answer);
            }
        }

        return answer;
    }
}
