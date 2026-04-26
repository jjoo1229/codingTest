import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for (int s : scoville) {
            pq.add(s);
        }
        
        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) return -1;
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            count++;
        }
        return count;
    }
}