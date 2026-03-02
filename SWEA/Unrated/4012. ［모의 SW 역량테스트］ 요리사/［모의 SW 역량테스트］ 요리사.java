import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, answer;
	public static int[][] map;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

            map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			visited = new boolean[n];
			comb(0, n / 2, visited);

			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static void comb(int index, int r, boolean[] visited) {
		if (r == 0) {
			int a = 0, b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					if (visited[i] && visited[j]) {
						a += map[i][j];
					} else if (!visited[i] && !visited[j]) {
						b += map[i][j];
					}
				}
			}
			answer = Math.min(answer, Math.abs(a - b));
			return;
		}

		for (int i = index; i < n; i++) {
			visited[i] = true;
			comb(i + 1, r - 1, visited);
			visited[i] = false;
		}
	}
}