import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, limit, max;
	public static int[][] grid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			grid = new int[n][2];

			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				grid[i][0] = Integer.parseInt(st2.nextToken());
				grid[i][1] = Integer.parseInt(st2.nextToken());
			}
            max = 0;
			dfs(0, limit, 0);
			System.out.printf("#%d %d%n", tc, max);
		}
	}

	public static void dfs(int index, int availableAmount, int point) {
		if (index == n) {
			max = Math.max(max, point);
			return;
		}

		if (availableAmount - grid[index][1] >= 0) {
			dfs(index + 1, availableAmount - grid[index][1], point + grid[index][0]);
		}
		dfs(index + 1, availableAmount, point);
	}
}