import java.util.*;
import java.io.*;

class Solution {
    static int[][] map = new int[16][16];
    static int startX;
    static int startY;
    static int arriveX;
    static int arriveY;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();
            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    } else if (map[i][j] == 3) {
                        arriveX = i;
                        arriveY = j;
                    }
                }
            }
            System.out.printf("#%d %d%n", test_case, dfs());
        }
    }

    public static int dfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        boolean[][] visited = new boolean[16][16];
        visited[startX][startY] = true;
        
        while (!stack.empty()) {
            int[] cur = stack.pop();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == arriveX && curY == arriveY) return 1;
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
                if (!visited[nx][ny] && map[nx][ny] != 1) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}