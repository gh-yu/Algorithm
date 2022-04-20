import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // Queue�� �������̽�, �ν��Ͻ�ȭ�Ϸ��� Queue�� ������ Ŭ���� �ۼ��ϰų� LinkedList �Ǵ� ArrayDeque ���
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
                    // poll() : ���� �տ� �ִ� ��� ���� & ������ ��� ����
                    printNum = q.poll();
                    break;
                case "size":
                    printNum = q.size();
                    break;
                case "empty":
                    printNum = q.isEmpty() ? 1 : 0;
                    break;
                case "front":
                    // peek() : ���� ���ϰ� ���� �տ� �ִ� ��� ���� 
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