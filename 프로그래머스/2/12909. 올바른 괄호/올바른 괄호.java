class Solution {
    boolean solution(String s) {
          int counter = 0;
          for (char a : s.toCharArray()) {
            if (a == '(') {
              counter += 1;
            } else if (a == ')') {
              counter -= 1;
            }

            if (counter < 0) {
              // 중간에 음수가 되면 닫는 괄호가 먼저 나온 것 → 잘못된 괄호
              return false; // 바로 false 반환
            }
          }
          return counter == 0;
    }
}