import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, b, answer;
	public static int[] heights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			heights = new int[n];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(st2.nextToken());
			}
			answer = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static void dfs(int sum, int index) {
		if (answer == 0) return;
		
		if (sum == b) {
			answer = 0;
			return;
		} else if (sum > b) {
			answer = Math.min(answer, sum - b);
			return;
		}
		
		if (index == n) return;

		if (sum < b) {
			dfs(sum + heights[index], index + 1);
		}
		dfs(sum, index + 1);
	}
}