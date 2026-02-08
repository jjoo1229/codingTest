import java.util.*;

public class Main {
	public static int n;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				char a = line.charAt(j);
				map[i][j] = a - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					list.add(bfs(i, j));
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int a : list) System.out.println(a);
	}

	public static int bfs(int x, int y) {
		int count = 1;
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

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
					count++;
				}
			}
		}
		return count;
	}
}
