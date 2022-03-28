package boj_10773_제로;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        // 첫 번째 줄에 주어지는 정수 K : 이후 입력될 줄의 개수
        final int K = sc.nextInt();
        
        for (int i = 0; i < K; i++) {
            int inputNum = sc.nextInt();

            if (inputNum == 0) {
                stack.pop(); // 0이 입력되면 stack 맨 위의 값을 꺼낸다(지운다).
            } else {
                stack.add(inputNum); // 0이 아닌 숫자가 입력되면 stack에 추가한다.
            }
        }
        
        // 최종적으로 적어 낸 수의 합을 출력
        int sum = 0;
        for (Integer s : stack) {
            sum += s; 
        }

        System.out.println(sum); 
    }
}
