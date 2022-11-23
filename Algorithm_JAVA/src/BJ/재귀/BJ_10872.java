package BJ.재귀;

import java.util.Scanner;

public class BJ_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        fac(N);

        int sum = 1;

        //반복문으로 했을 때
        while(N != 0) {
            sum = sum*N;
            N--;
        }
    } 

    private static int fac(int n) {
        if(n<=1) return 1; //재귀 종료 조건
        return n * fac(n-1);
    }
}
