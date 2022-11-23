package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine(); // n은 사용하지 않는 수이므로 입력을 받기만 한다

        /**
         * 방법1. String 값을 split하여 int형으로 변환하여 int[]에 저장한다
         * 시간 : 128ms
         */
        int[] input = Stream.of(String.valueOf(br.readLine()).split("")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for(int i : input) {
            sum += i;
        }

        /**
         * 방법 2. br.readLine.getBytes()
         * 주의 : sum에 더해줄 시 이를 변환해주어야 함
         * 시간 : 124ms
         */
        int sum2 = 0;
        for(byte b : br.readLine().getBytes()) {
            sum2 += (b-'0');
        }

        System.out.println(sum);
        System.out.print(sum2);
    }

}
