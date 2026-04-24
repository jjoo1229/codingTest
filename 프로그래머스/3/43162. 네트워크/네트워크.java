import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, computers);
                count++;
            }
        }
        return count;
    }
    
    public void bfs(int startNum, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNum);
        visited[startNum] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < computers[cur].length; i++) {
                if (!visited[i] && computers[i][cur] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}