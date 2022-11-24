package BJ.단계별.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 : 124ms
 */
public class BJ_1316 {
    static public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt=0;

        while(n-- > 0) {
            if(check()) {
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }

    public static boolean check() throws IOException{
        boolean[] check = new boolean[26]; 
        // 이후 반복문에서 문자를 꺼내올 때 앞선 문자와 연속되는지, 아닌지를 판별하기 위함
        int prev = 0; 
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            int now = str.charAt(i);
            // 앞선 문자와 i 번째 문자가 같지 않다면
            if (prev != now) {
                if(check[now - 'a'] == false) { //해당 문자가 처음 나오는 경우
                    check[now-'a'] = true; //나왔다고 true로 바꿔줌
                    prev = now; //다음 턴을 위해 prev도 바꿔줌
                } else { //해당 문자가 이미 나온 적 있는 경우 => 그룹 단어가 아님
                    return false;
                }
            } else { //앞선 단어와 같다 = 연속된 문자이다
                continue; 
            } 
        }

        return true;
    }
}
