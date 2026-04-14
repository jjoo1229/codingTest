import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static int[][] map = new int[501][501];
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			if (y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					map[x][y] = 1;
				}
			}
		}

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			if (y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					map[x][y] = Integer.MAX_VALUE;
				}
			}
		}
		System.out.print(dijkstra());
	}

	public static int dijkstra() {
		// 값, x, y로 넣기
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.add(new int[] { 0, 0, 0 });

		int[][] dist = new int[501][501];
		for (int i = 0; i <= 500; i++) {
			for (int j = 0; j <= 500; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curDist = cur[0];
			int curX = cur[1];
			int curY = cur[2];

			if (curDist < 0 || curDist == Integer.MAX_VALUE) {
				return -1;
			}
			if (curX == 500 && curY == 500) {
				return dist[500][500];
			}

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (nx < 0 || nx > 500 || ny < 0 || ny > 500)
					continue;

				if (dist[nx][ny] > curDist + map[nx][ny]) {
					dist[nx][ny] = curDist + map[nx][ny];
					pq.add(new int[] { dist[nx][ny], nx, ny });
				}
			}
		}
		return -1;
	}
}