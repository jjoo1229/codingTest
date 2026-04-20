import java.util.*;

class Solution {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return bfs(n, m, maps);
    }
    
    public int bfs(int n, int m, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCount = cur[2];
            
            if (curX == n-1 && curY == m-1) return curCount;
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, curCount + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}