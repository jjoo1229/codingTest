import java.util.*;
import java.io.*;

public class Main {
	public static int n, m;
	public static int[][] grid;
	public static int[][] minusGrid;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		minusGrid = new int[n][m];

		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		int year = 0;
		while (true) {
			for (int i = 0; i < n; i++) {
				Arrays.fill(minusGrid[i], 0); // 초기화
			}
			// 전체를 돌면서 녹는 애들 체크
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] > 0) {
						solve(i, j);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = (grid[i][j] - minusGrid[i][j] < 0) ? 0 : grid[i][j] - minusGrid[i][j];
				}
			}
			year++;
			if (moreThanTwoIce() || allMelt()) break;
		}
		System.out.print(allMelt() ? 0 : year);
	}

	public static void solve(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (grid[nx][ny] == 0) {
				count++;
			}
		}
		minusGrid[x][y] = count;
	}

	public static boolean moreThanTwoIce() {
		int count = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] > 0) {
					bfs(i, j, visited);
					count++;
					if (count > 2)
						return true;
				}
			}
		}
		if (count >= 2) return true;
		return false;
	}

	public static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[x][y] = true;
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (!visited[nx][ny] && grid[nx][ny] != 0) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });

				}
			}
		}
	}

	public static boolean allMelt() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0)
					return false;
			}
		}
		return true;
	}
}