import java.util.*;

public class Solution {
	public static int n;
	public static int[][] map;
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			min = Integer.MAX_VALUE;

			boolean[] visited = new boolean[n];
			combination(visited, 0, n / 2);

			System.out.printf("#%d %d%n", test_case, min);
		}
	}

	public static void combination(boolean[] visited, int start, int r) {
		int teamA = 0;
		int teamB = 0;

		if (r == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					if (visited[i] && visited[j]) {
						teamA += map[i][j] + map[j][i];
					} else if (!visited[i] && !visited[j]) {
						teamB += map[i][j] + map[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(teamA - teamB) / 2);
		}

		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
}