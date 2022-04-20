import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int horseNum = 0;
        for (int i = 1; i <= 8; i++) {

            char[] rank = br.readLine().toCharArray(); // 체스판의 한 행
            
            for (int j = 1; j <= 8; j++) {

                char square = rank[j-1]; // 체스판의 한 칸
                if (i % 2 == 0) { // 짝수 줄 => 검정 칸이 먼저 옴, 하얀 칸이 짝수 번째에 위치(검, 하, 검, 하, ..) 
                    
                    if (j % 2 == 0 && square == 'F') { // 칸이 짝수 번째에 위치하고 F면
                        horseNum++;
                    }
                } else { // 홀수 줄 => 하얀 칸이 먼저 옴, 하얀 칸이 홀수 번째에 위치(하, 검, 하, 검, ..) 

                    if (j % 2 != 0 && square == 'F') {  // 칸이 홀수 번째에 위치하고  F면
                        horseNum++;
                    }                    
                }
            }
        }

        System.out.println(horseNum);
    }
}
