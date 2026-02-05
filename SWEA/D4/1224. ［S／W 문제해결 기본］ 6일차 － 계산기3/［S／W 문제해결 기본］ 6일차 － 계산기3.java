import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
    		int n = sc.nextInt();
            String str = sc.next();
    		Stack<Character> stack = new Stack<>();
    		StringBuilder calc = new StringBuilder();

            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                
                if (c == '+' || c == '*') {
                    while (!stack.empty() && priority(stack.peek()) >= priority(c)) {
                        calc.append(stack.pop());
                    }
                    stack.push(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.empty()) {
                        char p = stack.pop();
                        if (p != '(') calc.append(p);
                        else break;
                    }
                } else {
                    calc.append(c);
                }
            }
            System.out.printf("#%d %d%n", test_case, calculate(calc.toString()));
		}
	}

    public static int priority(char c) {
        if (c == '(') return 0;
        else if (c == '+') return 1;
        else if (c == '*') return 2;
        return 0;
    }

    public static int calculate(String str) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '*') {
                int n2 = stack.pop();
                int n1 = stack.pop();
                if (c == '+') stack.push(n1 + n2);
                else stack.push(n1 * n2);
            } else {
                stack.push(c - '0');
            }
        }
        return stack.pop();
    }
}