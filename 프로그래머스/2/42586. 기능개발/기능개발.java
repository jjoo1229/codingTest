import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            int day = rest % speeds[i] == 0 ? (rest / speeds[i]) : (rest / speeds[i] + 1);
            q.add(day);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int count = 1;
            int cur = q.poll();  // 맨 앞에 빼서
            
            while (!q.isEmpty() && q.peek() <= cur) {  // 다음 애가 cur보다 더 작으면 같이 빼줌
                q.poll();
                count++;
            }
            System.out.println(count);
            answer.add(count);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}