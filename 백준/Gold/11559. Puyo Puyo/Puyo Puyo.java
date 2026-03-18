import java.util.*;
import java.io.*;

public class Main {
	public static char[][] map = new char[12][6];
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static boolean bomb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int turn = 0;
		while (true) {
			boolean[][] visited = new boolean[12][6];
			bomb = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && map[i][j] != '.') {
						check(i, j, visited); // 터뜨려서 .으로 바꾸기
					}
				}
			}
			
			if (!bomb) break;
			pullDown();
			turn++;
		}

		System.out.print(turn);
	}

	public static void check(int x, int y, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { x, y });
		visited[x][y] = true;
		int count = 1;
		char c = map[x][y];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
				if (!visited[nx][ny] && map[nx][ny] == c) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
					list.add(new int[] { nx, ny });
					count++;
				}
			}
		}
		if (count >= 4) {
			for (int[] li : list) {
				map[li[0]][li[1]] = '.';
			}
			bomb = true;
		}
	}

	public static void pullDown() {
		for (int j = 0; j < 6; j++) {
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < 12; i++) {
				if (map[i][j] != '.') {
					stack.addLast(map[i][j]);
				}
			}

			for (int i = 11; i >= 0; i--) {
				if (!stack.isEmpty())
					map[i][j] = stack.pollLast();
				else
					map[i][j] = '.';
			}
		}
	}

}