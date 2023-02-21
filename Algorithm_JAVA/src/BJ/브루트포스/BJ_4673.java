package BJ.브루트포스;

public class BJ_4673 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        boolean[] noneSelf = new boolean[10001];

        for(int i=1; i<=10001; i++) {
            int n = getNotSelfNumber(i);

            if(n <= 10000) noneSelf[n] = true;
        }

        for(int i=1; i<=10000; i++) {
            if(!noneSelf[i]) System.out.println(i);
        }
    }

    public static int getNotSelfNumber(int i) {
        int sum = i;

        while(i != 0) {
            sum += i%10;
            i /= 10;
        }

        return sum;
    }
}
