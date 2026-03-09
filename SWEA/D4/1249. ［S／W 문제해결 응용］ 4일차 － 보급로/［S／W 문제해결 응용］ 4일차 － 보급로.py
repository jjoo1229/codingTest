import java.io.*;
import java.util.*;

public class Solution {
	public static int t, n, answer;
	public static int[][] map;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			System.out.printf("#%d %d%n", tc, dijkstra());
		}
	}

	public static int dijkstra() {
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.offer(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curCost = cur[0];
			int x = cur[1];
			int y = cur[2];

			if (dist[x][y] < curCost) continue;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (curCost + map[nx][ny] < dist[nx][ny]) {
					dist[nx][ny] = curCost + map[nx][ny];
					pq.offer(new int[] { curCost + map[nx][ny], nx, ny });
				}
			}
		}

		return dist[n - 1][n - 1];
	}
}