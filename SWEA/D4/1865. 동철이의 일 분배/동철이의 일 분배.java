import java.io.*;
import java.util.*;

public class Solution {
	public static int t, n;
	public static double max;
	public static int[][] map;
	public static double answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] visited = new boolean[n];
			max = 0.0;
			dfs(0, 1.0, visited);
			System.out.printf("#%d %.6f%n", test_case, max * 100);
		}
	}

	public static void dfs(int index, double result, boolean[] visited) {
		if (index == n) {
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				double newResult = result * map[index][i] / 100.0;
				if (newResult <= max) continue;
				visited[i] = true;
				dfs(index + 1, newResult, visited);
				visited[i] = false;
			}
		}
	}
}