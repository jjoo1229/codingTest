import java.util.*;
import java.io.*;

public class Solution {
	public static int d, w, k, answer;
	public static int[][] grid;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
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
			answer = d;
			if (check())
				answer = 0;
			else
				dfs(0, 0);
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	public static boolean check() {
		if (k == 1)
			return true;

		for (int j = 0; j < w; j++) {
			boolean pass = false;
			int length = 1;

			for (int i = 1; i < d; i++) {
				if (grid[i - 1][j] == grid[i][j]) {
					length++;
				} else {
					length = 1;
				}

				if (length >= k) {
					pass = true;
					break;
				}
			}
			if (!pass) return false;

		}
		return true;
	}

	public static void dfs(int rowIndex, int count) {
		if (count >= answer) return; // count가 저장된 값보다 커지면 제외(가지치기)
		
		if (check()) {
			answer = Math.min(answer, count);
			return;
		}
			
		if (rowIndex == d) return;
		

		dfs(rowIndex + 1, count); // 아무것도 안 하고 넘어간다
		
		int[] temp = new int[w];
		for (int i = 0; i < w; i++) temp[i] = grid[rowIndex][i]; // 원래 row 저장
		
		for (int i = 0; i < w; i++) grid[rowIndex][i] = 0;
		dfs(rowIndex + 1, count + 1); // A로 바꿔준다

		for (int i = 0; i < w; i++) grid[rowIndex][i] = 1;
		dfs(rowIndex + 1, count + 1); // B로 바꿔준다

		for (int i = 0; i < w; i++) grid[rowIndex][i] = temp[i]; // 원상복구
	}
}
