import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
    		br.readLine();
            int[][] graph = new int[16][16];
            int startX = 0, startY = 0, endX = 0, endY = 0;
            
            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    graph[i][j] = line.charAt(j) - '0';  // '0'을 빼서 문자 -> 숫자 변환
                    if (graph[i][j] == 2) {
                        startX = i;
                        startY = j;
                    } else if (graph[i][j] == 3) {
                        endX = i;
                        endY = j;
                    }
                }
            }
            int answer = dfs(graph, startX, startY, endX, endY);
            System.out.printf("#%d %d%n", test_case, answer);
		}
	}

    public static int dfs(int[][] graph, int x1, int y1, int x2, int y2) {
         int[] dx = {0, 0, 1, -1};
         int[] dy = {1, -1, 0, 0};

        boolean[][] visited = new boolean[16][16];

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0];
            int y = cur[1];

            if (x == x2 && y == y2) return 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
                if (!visited[nx][ny] && graph[nx][ny] != 1) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}