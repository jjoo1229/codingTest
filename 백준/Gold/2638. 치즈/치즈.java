import java.util.*;

public class Main {
	public static int n, m;
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

		int time = 0; // 총 걸린 시간
		ArrayList<int[]> melt; // 녹는 치즈

		while (true) {
			map = checkOutsideAir(map); // 바깥 공기 확인하고
			melt = checkMeltCheese(map); // 녹일 치즈 확인

			for (int[] m : melt) {
				map[m[0]][m[1]] = 0; // 녹인다
			}

			boolean noCheese = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) noCheese = false;
				}
			}
			if (melt.size() > 0) time++;  // 녹은 애가 있으면 time++
			if (noCheese) break;  // 다 녹았으면 끝
		}
		System.out.print(time);
	}

	public static int[][] checkOutsideAir(int[][] map) { // 바깥 공기 확인
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (!visited[nx][ny] && map[nx][ny] != 1) {
					visited[nx][ny] = true;
					map[nx][ny] = 2;
					q.add(new int[] { nx, ny });
				}
			}
		}
		return map;
	}

	public static ArrayList<int[]> checkMeltCheese(int[][] map) { // 이번에 녹는 치즈 확인
		ArrayList<int[]> melt = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int meetCount = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if (map[i][j] == 1 && map[nx][ny] == 2)
						meetCount++;
				}
				if (meetCount >= 2)
					melt.add(new int[] { i, j });
			}
		}
		return melt;
	}
}