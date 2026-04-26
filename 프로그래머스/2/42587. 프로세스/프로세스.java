import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});  // [인덱스, 값] 형태로 저장
        }
        
        // [[0,2][1,1][2,3][3,2]]
        int turn = 0;
        while (true) {
            int[] cur = q.poll();  // [0,2]
            boolean haveToInsert = false;
            
            for (int[] rest : q) {
                if (rest[1] > cur[1]) {  // 우선순위끼리 비교 -> 남아있는 게 더 크면 
                    q.add(cur);
                    haveToInsert = true;
                    break;
                }
            }
            if (!haveToInsert) {
                turn++;
                if (location == cur[0]) return turn;
            }
        }
    }
}

// 뒤에 보면서 나보다 큰 애가 있는지 확인, 있으면 바로 뒤로 리턴
// 그러다 출력되는 경우 turn++, location이랑 같은지 확인.