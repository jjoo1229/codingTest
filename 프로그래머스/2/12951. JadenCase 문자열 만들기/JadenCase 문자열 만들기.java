import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ", -1);
        List<String> answer = new ArrayList<>();

        for (String a : arr) {
            if (a.equals("")) {
                answer.add("");
                continue;
            }

            char firstChar = a.charAt(0);

            // 첫 글자가 숫자가 아닌 경우
            if (!Character.isDigit(firstChar)) {
                String first = String.valueOf(Character.toUpperCase(firstChar));
                String rest = a.substring(1).toLowerCase();
                answer.add(first + rest);
            } else {
                answer.add(a.toLowerCase());
            }
        }

        return String.join(" ", answer);
    }
}