import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) {
                pq.add(num);
            } else if (cmd.equals("D") && num == 1) {  // 최댓값 삭제
                if (!pq.isEmpty()) pq.poll();
            } else if (cmd.equals("D") && num == -1) {  // 최솟값 삭제
                PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> a - b); // 오름차순
                while (pq.size() > 1) {
                    pq2.add(pq.poll());
                }
                pq.poll();
                while (!pq2.isEmpty()) {
                    pq.add(pq2.poll());
                }
            }
        }
        
        if (pq.isEmpty()) return new int[] {0, 0};
        else if (pq.size() == 1) {
            int num = pq.poll();
            return new int[] {num, num};
        } else {
            int max = pq.poll();
            while (pq.size() > 1) {
                pq.poll();
            }
            int min = pq.poll();
            return new int[]  {max, min};
        }
    }
}