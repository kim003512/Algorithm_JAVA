package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        String t1 = br.readLine();
        char[] tmp1 = new char[N1];
        for(int i=0; i<N1; i++) {
            tmp1[i] = t1.charAt(N1-i-1);
        }

        char[] tmp2 = br.readLine().toCharArray();

        char ants[] = new char[N1+N2];
        int dir[] = new int[N1+N2];
        for(int i=0; i<N1; i++) {
            ants[i] = tmp1[i];
            dir[i]=1; //정방향
        }
        for(int i=N1; i<N1+N2; i++) {
            ants[i] = tmp2[i-N1];
            dir[i] = 2; //반대 방향
        }

        int T = Integer.parseInt(br.readLine());

        while(T>0) {
            T--;
            for(int i=0; i<N1+N2-1; i++) {
                if(dir[i]==1 && dir[i+1]==2) {
                    System.out.println(i);
                    //정방향 개미 - 반대방향 개미 서로 교환
                    char t = ants[i];
                    ants[i] = ants[i+1];
                    ants[i+1] = t;

                    int td = dir[i];
                    dir[i]=dir[i+1];
                    dir[i+1] = td;
                    i++;
                    System.out.println(Arrays.toString(ants));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N1+N2; i++) {
            sb.append(ants[i]);
        }

        System.out.println(sb);
    }
}
