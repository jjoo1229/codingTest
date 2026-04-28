import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peekLast() < num && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num);
        }
        while (k-- > 0) stack.pollLast();  // 남아있으면 뒤에서 제거(내림차순이거나 동일한 경우)
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}