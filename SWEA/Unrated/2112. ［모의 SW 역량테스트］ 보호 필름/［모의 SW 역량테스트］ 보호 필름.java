import java.io.*;
import java.util.*;

public class Solution {
	public static int t, d, w, k, count;
	public static int[][] grid;

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
			count = k; // 최댓값인 k로 초기화
			if (checkQual(grid))
				count = 0; // 처음부터 가능이면 바로 0
			else {
				dfs(0, 0, grid);
			}
			System.out.printf("#%d %d%n", tc, count);
		}
	}

	// 해당 줄을 0으로 바꾸거나 1로 바꾸거나 그대로 간다 그리고 매번 가능한지 확인
	public static void dfs(int index, int injectCnt, int[][] newGrid) {
		if (injectCnt > count) return;  // 이미 count보다 많으면 그냥 리턴

		if (checkQual(newGrid)) {
			count = Math.min(count, injectCnt);
			return;
		}

		if (index == d) return; // 다 돌았으면 그냥 리턴

		dfs(index + 1, injectCnt, newGrid); // 그대로 간다

		int[] temp = new int[w]; // temp에 index번째 줄 저장
		for (int i = 0; i < w; i++) {
			temp[i] = newGrid[index][i];
		}

		for (int i = 0; i < w; i++) {
			newGrid[index][i] = 0;
		}
		dfs(index + 1, injectCnt + 1, newGrid); // 0으로 바꾸고 간다

		for (int i = 0; i < w; i++) {
			newGrid[index][i] = 1;
		}
		dfs(index + 1, injectCnt + 1, newGrid); // 1로 바꾸고 간다

		for (int i = 0; i < w; i++) {
			newGrid[index][i] = temp[i]; // 원상복구
		}
	}

	public static boolean checkQual(int[][] newGrid) {
		for (int j = 0; j < w; j++) {
			int curCount = 1;
			for (int i = 1; i < d; i++) {
				if (newGrid[i][j] == newGrid[i - 1][j]) { // 내 앞에 거랑 같으면
					curCount++;
				} else {
					if (curCount >= k)
						break; // 이미 k개 이상이니까 패스
					else
						curCount = 1;
				}
			}
			if (curCount < k)
				return false;
		}
		return true;
	}
}