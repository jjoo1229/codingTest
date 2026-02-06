import java.util.*;
  
class Solution {
    static int n;
    static int[][] map;
    static int startX;
    static int startY;
    static int arriveX;
    static int arriveY;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            startX = sc.nextInt();
            startY = sc.nextInt();
            arriveX = sc.nextInt();
            arriveY = sc.nextInt();

            System.out.printf("#%d %d%n", test_case, bfs());
        }
    }

    public static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        boolean[][] visited = new boolean[n][n];

        pq.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == arriveX && y == arriveY) return count;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        pq.add(new int[]{nx, ny, count + 1});
                        visited[nx][ny] = true;
                    } else if (map[nx][ny] == 2) {
                        if (count % 3 == 0) {
                            pq.add(new int[]{nx, ny, count + 3});
                        } else if (count % 3 == 1) {
                            pq.add(new int[]{nx, ny, count + 2});
                        } else if (count % 3 == 2) {
                            pq.add(new int[]{nx, ny, count + 1});
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}