import java.io.*;
import java.util.*;

public class Solution {
	public static int t, n, w, h, answer;
	public static int[][] bricks;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			bricks = new int[h][w];
			for (int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					bricks[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			int[] output = new int[n];
			permWRepeat(0, output, bricks);

			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static int[][] copy(int[][] original) {
		int[][] result = new int[h][w];
		for (int i = 0; i < h; i++) {
			System.arraycopy(original[i], 0, result[i], 0, w);
		}
		return result;
	}

	public static void permWRepeat(int depth, int[] output, int[][] curBricks) {
		if (answer == 0) return;

		if (depth == n) {
			answer = Math.min(answer, checkBricks(curBricks));
			return;
		}

		for (int i = 0; i < w; i++) {
			int[][] newBricks = copy(curBricks);
			handleBlocks(i, newBricks);
			permWRepeat(depth + 1, output, newBricks);
		}
	}

	public static void handleBlocks(int col, int[][] newBricks) {
		for (int i = 0; i < h; i++) {
			if (newBricks[i][col] != 0) {
				blowUpBlocks(i, col, newBricks); // col열의 블록에 떨어뜨림
				break;
			}
		}

		dropBlocks(newBricks);
	}

	public static void blowUpBlocks(int x, int y, int[][] newBricks) {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> bomb = new ArrayList<>();
		q.add(new int[] { x, y });
		bomb.add(new int[] { x, y });
		boolean[][] visited = new boolean[h][w];
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int value = newBricks[curX][curY];

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < value; j++) {
					int nx = curX + dx[i] * j;
					int ny = curY + dy[i] * j;

					if (nx < 0 || nx >= h || ny < 0 || ny >= w || newBricks[nx][ny] == 0)
						continue;
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny });
						bomb.add(new int[] { nx, ny });
					}
				}
			}
		}
		for (int[] b : bomb) {
			newBricks[b[0]][b[1]] = 0;
		}
	}

	public static void dropBlocks(int[][] newBricks) {
		Queue<Integer> q = new LinkedList<>();
		for (int j = 0; j < w; j++) {
			// 밑에서부터 위로 오면서 블록 모으기
			for (int i = h - 1; i >= 0; i--) {
				if (newBricks[i][j] != 0) {
					q.offer(newBricks[i][j]);
				}
			}

			for (int i = h - 1; i >= 0; i--) {
				newBricks[i][j] = !q.isEmpty() ? q.poll() : 0;
			}
		}
	}

	public static int checkBricks(int[][] newBricks) { // 다 폭발한 후 벽돌 개수 체크
		int count = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (newBricks[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}
}