import java.util.*;
  
class Solution {
    static int n;
    static int[][] graph;
    static boolean[] visited;
     
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            graph = new int[n][n];
            visited = new boolean[n * n + 1];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            int count = 0, answer = 0;
            int room = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int roomNo = graph[i][j];
                    if (visited[roomNo]) continue;
                    count = solve(i,j);
                    if (count == answer) {
                        room = Math.min(room, roomNo);
                    } else if (count > answer) {
                        answer = count;
                        room = roomNo;
                    }
                }
            }

            System.out.printf("#%d %d %d%n", test_case, room, answer);
        }
    }
  
    public static int solve(int x, int y) {
        visited[graph[x][y]] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
              
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (graph[nx][ny] == graph[x][y] + 1) {
                return solve(nx, ny) + 1;
            }
        }
        return 1;
    }
}