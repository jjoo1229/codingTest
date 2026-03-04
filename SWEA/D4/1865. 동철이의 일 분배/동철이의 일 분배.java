import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n;
	public static double answer;
	public static int[][] work;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			work = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					work[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0.0;
			boolean[] visited = new boolean[n];
			dfs(0, 1.0, visited);
			System.out.printf("#%d %f%n", tc, answer * 100);
		}
	}

	public static void dfs(int index, double val, boolean[] visited) {
		if (val <= answer) return;
		
		if (index == n) {
			answer = Math.max(val, answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(index + 1, val * work[index][i] / 100.0, visited);
				visited[i] = false;
			}
		}
	}
}