package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(solution2(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

       // Stack<Integer> stack = new Stack<>();
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1] != 0) {
                    stack.add(board[j][moves[i] -1]);
                    board[j][moves[i] - 1] = 0;

                    if (stack.size() >= 2 && stack.get(stack.size()-2) == stack.get(stack.size()-1)) {
                        stack.remove(stack.size()-1);
                        stack.remove(stack.size()-1);
                        answer += 2;
                    }
                    break;
                }

                // if (!stack.empty()) {
                // if (stack.peek() == board[j][moves[i] - 1]) {
                // answer += 2;
                // stack.pop();
                // break;
                // } else {
                // stack.push(board[j][moves[i] - 1]);
                // board[j][moves[i] - 1] = 0;
                // break;
                // }
                // } else {
                // stack.push(board[j][moves[i] - 1]);
                // board[j][moves[i] - 1] = 0;
                // break;
                // }
            }
        }

        return answer;
    }

    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int move : moves) {
            for(int j=0; j<board.length; j++) {
                if(board[j][move-1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[j][move-1]);
                        board[j][move-1] = 0;
                        break;
                    }
                    if(board[j][move-1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move-1]);
                    }
                    board[j][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
