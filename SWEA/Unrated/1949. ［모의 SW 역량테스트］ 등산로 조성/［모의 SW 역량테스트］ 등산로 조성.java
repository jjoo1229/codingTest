import java.util.*;

public class Solution {
	public static int n;
	public static int k;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			int maxPoint = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					maxPoint = Math.max(map[i][j], maxPoint);
				}
			}

			// 제일 높은 봉우리 저장
			ArrayList<int[]> maxSpot = new ArrayList<>();
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (map[x][y] == maxPoint) {
						maxSpot.add(new int[] { x, y });
					}
				}
			}

			answer = 1;
			visited = new boolean[n][n];
			for (int[] ms : maxSpot) {
				dfs(ms[0], ms[1], 1, false);
			}

			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static void dfs(int x, int y, int length, boolean cut) {
		answer = Math.max(answer, length);

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
				continue;

			if (map[x][y] > map[nx][ny]) {
				dfs(nx, ny, length + 1, cut);
			} else if (!cut && map[x][y] > map[nx][ny] - k) {
				int originalHeight = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				dfs(nx, ny, length + 1, true);
				map[nx][ny] = originalHeight;
			}
		}
		visited[x][y] = false;
	}
}