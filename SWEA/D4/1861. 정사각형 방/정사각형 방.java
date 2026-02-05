import java.util.*;
 
class Solution {
    static int n;
    static int[][] dp;
    static int[][] graph;
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            graph = new int[n][n];
            dp = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    solve(i, j);
                }
            }
            
            int max = 0;
            int room = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        room = graph[i][j];
                    } else if (dp[i][j] == max) {
                        room = Math.min(room, graph[i][j]);
                    }
                }
            }
            System.out.printf("#%d %d %d%n", test_case, room, max);
        }
    }
 
    public static int solve(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
             
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (graph[nx][ny] == graph[x][y] + 1) {
                dp[x][y] = 1 + solve(nx, ny);
            }
        }
        return dp[x][y];
    }
}