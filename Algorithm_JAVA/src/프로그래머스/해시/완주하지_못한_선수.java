package 프로그래머스.해시;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"leo", "kiki"};
        완주하지_못한_선수 sol = new 완주하지_못한_선수();

        System.out.println(sol.solution4(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> arr1 = new ArrayList<String>();
        List<String> arr2 = new ArrayList<String>();

        for(String parti : participant) {
            arr1.add(parti);
        }
        for(String comple : completion) {
            arr2.add(comple);
        }
        arr1.removeAll(arr2);

        answer = arr1.toString();

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i=0;
        for(i=0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        return participant[i];
    }

    public String solution3(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for (String person : completion) {
           if (!Arrays.asList(participant).contains(person)) {
            break;
           }
           answer = person;
        }
        return answer;
    }

    public String solution4(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for(String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for(String player : completion) hm.put(player, hm.get(player) -1);

        System.out.println(hm);

        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
