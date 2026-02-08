import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static int[][] map;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int time = 0;
		int iceNum = 0;
		while (true) {
			// 빙산 녹이기
			int[][] melt = new int[n][m]; // 각 칸에서 녹아야 하는 만큼 저장
			ArrayList<int[]> list = new ArrayList<>(); // 녹을 자리 저장용

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						int count = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];

							if (nx < 0 || nx >= n || ny < 0 || ny >= m)
								continue;
							if (map[nx][ny] == 0)
								count++;
						}
						melt[i][j] = (map[i][j] - count > 0) ? count : map[i][j];
						list.add(new int[] { i, j });
					}
				}
			}
			for (int[] cur : list) { // 한꺼번에 녹이기
				int curX = cur[0], curY = cur[1];
				map[curX][curY] -= melt[curX][curY];
			}
			time++;

			// 빙산 개수 구하기
			iceNum = 0;
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						bfs(i, j, visited);
						iceNum++;
					}
				}
			}
			if (iceNum > 1 || iceNum == 0)
				break;
		}
		System.out.print(iceNum == 0 ? 0 : time);
	}

	public static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (nx < 0 || nx > n || ny < 0 || ny >= m)
					continue;
				if (!visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
