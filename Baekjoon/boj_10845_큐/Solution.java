import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // Queue는 인터페이스, 인스턴스화하려면 Queue를 구현한 클래스 작성하거나 LinkedList 또는 ArrayDeque 사용
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");
            String command = input[0];
            
            Integer printNum = null;
            switch (command) {
                case "push":
                    q.add(Integer.parseInt(input[1]));
                    continue;
                case "pop":
                    // poll() : 가장 앞에 있는 요소 삭제 & 삭제한 요소 리턴
                    printNum = q.poll();
                    break;
                case "size":
                    printNum = q.size();
                    break;
                case "empty":
                    printNum = q.isEmpty() ? 1 : 0;
                    break;
                case "front":
                    // peek() : 삭제 안하고 가장 앞에 있는 요소 리턴 
                    printNum = q.peek();
                    break;
                case "back":
                    int idx = 0;
                    for (Integer num : q) {
                        idx++;
                        if (idx == q.size()) {
                            printNum = num;
                        }
                    }
            }

            System.out.println(printNum == null ? -1 : printNum);
        }            
    }
}