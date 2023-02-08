public class 다트_게임 {
    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();

        int[] round = new int[3];
        int idx = 0;
        String nowNum = "";
        for(int i=0; i<arr.length; i++) {
            //숫자
            if(arr[i] >='0' && arr[i] <='9') {
                nowNum += arr[i];
            }
            //문자
            else if (arr[i] == 'S' ||arr[i] == 'D' ||arr[i] == 'T') {
                if(arr[i] == 'S') {
                    round[idx++] = (int) Math.pow(Integer.parseInt(nowNum), 1);
                } else if(arr[i] == 'D') {
                    round[idx++] = (int) Math.pow(Integer.parseInt(nowNum), 2);
                } else if(arr[i] == 'T') {
                    round[idx++] = (int) Math.pow(Integer.parseInt(nowNum), 3);
                }
                nowNum = "";
            }
            //보너스
            else if(arr[i] == '*' || arr[i] == '#') {
                if(arr[i] == '*') {
                    round[idx-1] = round[idx-1] * 2;
                    if(idx - 2 >= 0) round[idx-2] *= 2;
                } else if(arr[i] == '#') {
                    round[idx-1] = round[idx-1] * -1;
                }
            }
        }
        return round[0]+round[1]+round[2];
    }
}
