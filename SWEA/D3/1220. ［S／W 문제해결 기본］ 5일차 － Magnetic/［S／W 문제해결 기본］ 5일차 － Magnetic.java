import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
    		sc.nextInt();
            
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
            		arr[i][j] = sc.nextInt();
                }
            }
            
            // 교착 상태가 생기는 경우 -> column에서 1 다음에 2가 나오는 경우만 체크
            // 2 다음 1이 나오는 것은 상관없음
            int count = 0;
            for (int j = 0; j < 100; j++) {
                Stack<Integer> stack = new Stack<>();
                
                for (int i = 0; i < 100; i++) {
            		if (arr[i][j] == 1) {
                        stack.push(1);
                    } else if (arr[i][j] == 2) {
                        if (!stack.empty() && stack.peek() == 1) {
                            count++;
                            stack.clear();
                        }
                    }
                }
            }
			System.out.printf("#%d %d%n", test_case, count);
		}
    }    
}