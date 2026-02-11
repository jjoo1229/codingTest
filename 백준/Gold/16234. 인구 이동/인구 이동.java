import java.util.*;

public class Main {
	public static int n;
	public static int l;
	public static int r;
	public static int[][] map;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int day = 0; // 며칠 지났는지
		while (true) {
			ArrayList<ArrayList<int[]>> totalTeam = new ArrayList<>(); // 연합 모음
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// bfs 처리 : 같은 연합 구하기
					if (!visited[i][j]) {
						ArrayList<int[]> team = bfs(visited, i, j);
						totalTeam.add(team);
					}
				}
			}
			
			if (totalTeam.size() == n * n)
				break;

			for (ArrayList<int[]> team : totalTeam) {
				move(team);
			}
			day++;
		}
		System.out.println(day);
		sc.close();
	}

	public static ArrayList<int[]> bfs(boolean[][] visited, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> team = new ArrayList<>();
		q.offer(new int[] { x, y });
		team.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				int diff = Math.abs(map[curX][curY] - map[nx][ny]);
				if (!visited[nx][ny] && l <= diff && diff <= r) {
					q.offer(new int[] { nx, ny });
					team.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
		return team;
	}

	public static void move(ArrayList<int[]> team) {
		int num = team.size(); // 총 몇 팀인지
		int sum = 0;
		for (int[] t : team) {
			sum += map[t[0]][t[1]];
		}
		int avg = sum / num;
		for (int[] t : team) {
			map[t[0]][t[1]] = avg;
		}
	}
}
