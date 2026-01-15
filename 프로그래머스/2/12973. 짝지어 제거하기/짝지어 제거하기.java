import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        int i = 1;
        while (i < s.length()) {
            char now = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
            } else {
                stack.push(now);
            }
            i++;
        }

        return stack.isEmpty() ? 1 : 0;
    }
}