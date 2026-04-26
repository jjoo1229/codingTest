import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String[] line = clothes[i];
            String what = line[0];
            String type = line[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int i : map.values()) {
            // System.out.println(i);
            answer *= (i + 1);
        }
        return answer - 1;
    }
}
    