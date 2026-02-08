import java.util.*;

public class Main {
	public static int n;
	public static int[][] map;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int answer = 1;  // 비가 오지 않는 경우 -> 한 군데도 안 잠겨서 총 1개가 나옴
		for (int i = min; i <= max; i++) {
			boolean[][] visited = new boolean[n][n];
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (!visited[j][k] && map[j][k] > i) {
						bfs(j, k, i, visited);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.print(answer);
	}

	public static void bfs(int x, int y, int limit, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (!visited[nx][ny] && map[nx][ny] > limit) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
