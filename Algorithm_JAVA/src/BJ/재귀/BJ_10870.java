package BJ.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fib(n));

        int[] fibo = new int[n+1];
        for(int i=0; i<=n; i++) {
            if (i==0) fibo[i] = 0;
            else if (i==1) fibo[i] = 1;

            else fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(Arrays.toString(fibo));
        System.out.println(fibo[n]);
    }

    private static int fib(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;

        return fib(n-1) + fib(n-2);
    }
}
