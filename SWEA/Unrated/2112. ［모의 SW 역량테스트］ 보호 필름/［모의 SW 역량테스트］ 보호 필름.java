import java.io.*;
import java.util.*;

public class Solution {
	public static int t, d, w, k, count;
	public static int[][] grid;
	public static int[] rowState;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			grid = new int[d][w];
			for (int i = 0; i < d; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					grid[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			rowState = new int[d];
			Arrays.fill(rowState, -1);
			count = k; // 최댓값인 k로 초기화
			if (checkQual()) count = 0; // 처음부터 가능이면 바로 0
			else {
				dfs(0, 0);
			}
			System.out.printf("#%d %d%n", tc, count);
		}
	}

	// 해당 줄을 0으로 바꾸거나 1로 바꾸거나 그대로 간다 그리고 매번 가능한지 확인
	public static void dfs(int index, int injectCnt) {
		if (injectCnt >= count) return; // 이미 count보다 많으면 그냥 리턴

		if (index == d) {
			if (checkQual()) {
				count = Math.min(count, injectCnt);
			}
			return;
		}

		rowState[index] = -1;
		dfs(index + 1, injectCnt); // 그대로 간다

		// 0으로 바꾸고 간다
		rowState[index] = 0;
		dfs(index + 1, injectCnt + 1);

		// 1로 바꾸고 간다
		rowState[index] = 1;
		dfs(index + 1, injectCnt + 1);
	}

	public static boolean checkQual() {
		for (int j = 0; j < w; j++) {
			int curCount = 1;
			for (int i = 1; i < d; i++) {
//				rowState[i]가 -1이면 grid[i][j], 아니면 rowState[i] 값을 사용한다.
				int prev = (rowState[i - 1] == -1) ? grid[i - 1][j] : rowState[i - 1];
				int cur = (rowState[i] == -1) ? grid[i][j] : rowState[i];
				if (cur == prev) {
					curCount++;
				} else {
					if (curCount >= k)
						break; // 이미 k개 이상이니까 패스
					else
						curCount = 1;
				}
			}
			if (curCount < k) return false;
		}
		return true;
	}
}