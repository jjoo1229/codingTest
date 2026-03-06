import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, answer;
	public static int[][] map;
	public static ArrayList<int[]> tomato;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		tomato = new ArrayList<>();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == 1) {
					tomato.add(new int[] { i, j });
				}
			}
		}
		
		if (!checkZero(map)) {
			answer = 0;
		} else {
			bfs();
			if (checkZero(map)) answer = -1;
			else answer = checkMax(map) - 1;
		}
		System.out.print(answer);
	}

	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < tomato.size(); i++) {
			int x = tomato.get(i)[0];
			int y = tomato.get(i)[1];
			q.offer(new int[] { x, y });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (map[nx][ny] == 0) {
					map[nx][ny] = map[curX][curY] + 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static boolean checkZero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					return true;
			}
		}
		return false;
	}

	public static int checkMax(int[][] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		return max;
	}
}