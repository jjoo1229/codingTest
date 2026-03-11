import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, limit;
	public static int[][] ings;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			ings = new int[n][2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				ings[i][0] = Integer.parseInt(st2.nextToken());
				ings[i][1] = Integer.parseInt(st2.nextToken());
			}

			int[] dp = new int[limit + 1];
			for (int i = 0; i < n; i++) {
				int score = ings[i][0];
				int cal = ings[i][1];

				for (int c = limit; c >= cal; c--) {
					dp[c] = Math.max(dp[c], dp[c - cal] + score);
				}
			}
			System.out.printf("#%d %d%n", tc, dp[limit]);
		}
	}
}