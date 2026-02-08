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
		ArrayList<int[]> list;
		while (true) {
			map = getOutside(map);
			list = getBottom(map);

			// 바깥 치즈 녹이기
			for (int[] l : list) {
				map[l[0]][l[1]] = 2;
			}

			// 공기를 0으로 처리
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 2)
						map[i][j] = 0;
				}
			}

			boolean noCheese = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1)
						noCheese = false;
				}
			}
			if (list.size() > 0) time++;
			if (noCheese) break;
		}
		System.out.println(time);
		System.out.println(list.size());
	}

	// 바깥 공기 체크
	public static int[][] getOutside(int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		return map;
	}

	public static ArrayList<int[]> getBottom(int[][] map) {
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (map[i][j] == 1 && map[nx][ny] == 2) {
						list.add(new int[] { i, j });
						break;
					}
				}
			}
		}
		return list;
	}
}