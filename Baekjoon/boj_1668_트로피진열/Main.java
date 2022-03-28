package boj_1668_트로피진열;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int trophyNum = sc.nextInt();
        int[] trophys = new int[trophyNum];

        for (int i = 0; i < trophyNum; i++) {
            trophys[i] = sc.nextInt();
        }

        int leftVision = 0;
        int rightVision = 0;
        int leftMax = 0;
        int rightMax = 0;

        for (int i = 0; i < trophyNum; i++) {
            if (leftMax < trophys[i]) {
                leftVision++;
                leftMax = trophys[i];
            }

            if (rightMax < trophys[trophyNum-1-i]) {
                rightVision++;
                rightMax = trophys[trophyNum-1-i];
            }
        }         

        System.out.println(leftVision);
        System.out.println(rightVision);
    }
}
