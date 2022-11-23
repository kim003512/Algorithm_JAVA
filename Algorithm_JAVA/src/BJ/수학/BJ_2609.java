package BJ.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int max = 0; 

        for(int i=1; i<=a; i++) {
            if(a%i==0 && b%i==0) max = i;
        }

        int min = (a*b)/max;

        System.out.println(min);
        System.out.print(max);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
