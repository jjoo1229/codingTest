import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);		
		for (int test_case = 1; test_case <= 10; test_case++) {
    		int n = sc.nextInt();
    		String str = sc.next();
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (!stack.empty() && stack.peek() == c) stack.pop();
                else stack.push(c);
            }
            StringBuilder sb = new StringBuilder();
            for (char s : stack) sb.append(s);
            System.out.printf("#%d %s%n", test_case, sb.toString());
		}
	}
}