package BJ.단계별.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(factorial(n));
    }

    public static int factorial(int n) {
        if(n <= 1) return 1; //재귀 종료 조건
        return factorial(n-1) * n;
    }
}
