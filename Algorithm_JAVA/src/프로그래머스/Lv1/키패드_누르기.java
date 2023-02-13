package 프로그래머스.Lv1;

public class 키패드_누르기 {
    static int[][] phone = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };

        System.out.println(solution2(numbers, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int lX = 3;
        int lY = 0;
        int rX = 3;
        int rY = 2;

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                for (int k = 0; k < 3; k++) {
                    for (int q = 0; q < phone[k].length; q++) {
                        if (phone[k][q] == i) {
                            lX = k;
                            lY = q;
                        }
                    }
                }
            } else if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                for (int k = 0; k < 3; k++) {
                    for (int q = 0; q < phone[k].length; q++) {
                        if (phone[k][q] == i) {
                            rX = k;
                            rY = q;
                        }
                    }
                }
            } else {
                int x = 0;
                int y = 0;
                for (int k = 0; k < phone.length; k++) {
                    for (int q = 0; q < phone[k].length; q++) {
                        if (phone[k][q] == i) {
                            x = k;
                            y = q;
                        }
                    }
                }
                double one = getDistance(x, y, lX, lY);
                double two = getDistance(x, y, rX, rY);

                if (one < two) {
                    answer += "L";
                    for (int k = 0; k < 3; k++) {
                        for (int q = 0; q < phone[k].length; q++) {
                            if (phone[k][q] == i) {
                                lX = k;
                                lY = q;
                            }
                        }
                    }
                } else if (one > two) {
                    answer += "R";
                    for (int k = 0; k < 3; k++) {
                        for (int q = 0; q < phone[k].length; q++) {
                            if (phone[k][q] == i) {
                                rX = k;
                                rY = q;
                            }
                        }
                    }
                } else if (one == two) {
                    if (hand == "right") {
                        answer += "R";
                        for (int k = 0; k < 3; k++) {
                            for (int q = 0; q < phone[k].length; q++) {
                                if (phone[k][q] == i) {
                                    rX = k;
                                    rY = q;
                                }
                            }
                        }
                    } else if (hand == "left") {
                        answer += "L";
                        for (int k = 0; k < 3; k++) {
                            for (int q = 0; q < phone[k].length; q++) {
                                if (phone[k][q] == i) {
                                    lX = k;
                                    lY = q;
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    static double getDistance(int x, int y, int x1, int y1) {
        double d;
        int xd, yd;
        yd = (int) Math.pow((y1 - y), 2);
        xd = (int) Math.pow((x1 - x), 2);
        d = Math.sqrt(yd + xd);

        return d;
    }

    static int [][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    static int[] leftPos = {3,0};
    static int[] rightPos = {3,2};
    static String hand;

    public static String solution2(int[] numbers, String hand) {
        hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";

        for(int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {
                leftPos = numpadPos[num]; 
                continue;
            }
            if(Umji.equals("R")) {
                rightPos = numpadPos[num]; 
                continue;
            }
        }

        return answer;
    }

    public static String pushNumber(int num) {
        if (num == 1 || num == 4 || num == 7) return "L";
        if (num == 3 || num == 6 || num == 9) return "R";
        
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        return hand; //같으면
    }

    public static int getDist(int[] pos, int num) {
        return Math.abs(pos[0] - numpadPos[num][0]) + Math.abs(pos[1] - numpadPos[num][1]);
    }
}
