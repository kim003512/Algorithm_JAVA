package 프로그래머스.Lv1;

public class 비밀지도 {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        solution(5, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            //String binary1 = String.format("%05s", Integer.toBinaryString(arr1[i]));
            //String binary2 = String.format("%05s", Integer.toBinaryString(arr2[i]));
            
            //2진수 변환
            String binary = Integer.toString(arr1[i]|arr2[i], 2);
            binary = binary.replace("0", " ");
            binary = binary.replace("1", "#");

            if(binary.length() != n) {
                String a = "";
                for(int j=0; j<n-binary.length(); j++) a += " ";
                binary = a + binary;
            }
            answer[i] = binary;
        }
    
        return answer;
    }
}
