import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static char[][] map;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					int dist = bfs(i, j);
					answer = Math.max(answer, dist);
				}
			}
		}
		System.out.print(answer);
	}

	public static int bfs(int x, int y) {
		int count = 0;
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();

		visited[x][y] = true;
		q.offer(new int[] { x, y, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			count = cur[2];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (!visited[nx][ny] && map[nx][ny] == 'L') {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, count + 1 });
				}
			}
		}
		return count;
	}
}