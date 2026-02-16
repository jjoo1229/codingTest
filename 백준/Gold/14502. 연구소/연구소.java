import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, answer;
	public static int[][] map;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static ArrayList<int[]> virus;
	public static ArrayList<int[]> normal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		virus = new ArrayList<>();
		normal = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == 0)
					normal.add(new int[] { i, j });
				else if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		answer = 0;
		makeWall(map, 0, 0);
		System.out.print(answer);
	}

	public static void makeWall(int[][] map, int index, int count) {
		if (count == 3) { // 벽이 3개면
			int[][] cloneMap = new int[n][m]; // 바이러스 퍼지는 거 확인용
			for (int i = 0; i < n; i++)
				cloneMap[i] = map[i].clone();

			boolean[][] visitedVirus = new boolean[n][m]; // 바이러스 방문여부

			spread(cloneMap, visitedVirus); // 바이러스 퍼짐

			answer = Math.max(answer, countArea(cloneMap));
			return;
		}

		for (int i = index; i < normal.size(); i++) {
			int[] cur = normal.get(i);
			map[cur[0]][cur[1]] = 1;
			makeWall(map, i + 1, count + 1);
			map[cur[0]][cur[1]] = 0;
		}
	}

	public static void spread(int[][] map, boolean[][] visitedVirus) {
		Queue<int[]> q = new LinkedList<>();
		for (int[] v : virus) {
			q.add(new int[] { v[0], v[1] });
			visitedVirus[v[0]][v[1]] = true;
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (!visitedVirus[nx][ny] && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.add(new int[] { nx, ny });
					visitedVirus[nx][ny] = true;
				}
			}
		}
	}

	public static int countArea(int[][] map) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}