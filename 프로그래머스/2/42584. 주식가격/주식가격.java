import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0 ; i < n; i++) {
            q.add(new int[] {i, prices[i]});  // [인덱스, 값] 형태의 큐로 변경해줌
        }

        while (!q.isEmpty()) {
            int time = 0;
            int[] cur = q.poll();
            int index = cur[0];
            int price = cur[1];

            for (int[] rest : q) {
                time++;
                if (rest[1] < price) break;  // 가격이 떨어졌으면 바로 종료
            }
            answer[index] = time;
        }
        return answer;
    }
}