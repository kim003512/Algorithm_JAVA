package BJ.재귀;

import java.util.Arrays;

public class ex {
    public static void main(String[] args) {
        int arr[] = {0, 80, 60, 30, 40, 100};
        System.out.println(ArraySort(arr, 4));
    }
    public static int ArraySort(int[] arr, int n) {
        int x;
        System.out.println(Arrays.toString(arr) + " "+n);
        if(n==1) return arr[0];
        else x = ArraySort(arr, n-1);

        if(x>arr[n-1]) return x;
        else return arr[n-1];
    }
}
