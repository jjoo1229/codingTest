import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            
            Character[] open = {'(', '{', '[', '<'};
            Character[] close = {')', '}', ']', '>'};

            int answer = 0;
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                
                if (Arrays.asList(open).contains(c)) stack.push(c);
                else {
                    if (stack.isEmpty()) break;
                    else {
                        char s = stack.peek();
                        if (s == '(' && c==')') stack.pop();
                        else if (s == '{' && c=='}') stack.pop();
                        else if (s == '[' && c==']') stack.pop();
                        else if (s == '<' && c=='>') stack.pop();
                        else break;
                    }
                }
            }
            if (stack.size() == 0) answer = 1;

            System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}