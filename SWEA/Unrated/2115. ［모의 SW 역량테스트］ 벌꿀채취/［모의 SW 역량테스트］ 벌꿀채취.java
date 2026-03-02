import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, m, c, answer, max;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			ArrayList<int[]> honeyList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					int[] honeyPots = new int[m];
					int index = 0;
					for (int k = j; k < j + m; k++) {
						honeyPots[index++] = map[i][k];
					}
					max = 0;
					dfs(honeyPots, 0, 0, 0);
					honeyList.add(new int[] { max, i, j, j + m - 1 });
				}
			}
			
			solve(honeyList);
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static void solve(ArrayList<int[]> honeyList) {
		answer = 0;
		for (int i = 0; i < honeyList.size(); i++) {
			for (int j = i+1; j < honeyList.size(); j++) {
				if (isPossible(honeyList.get(i), honeyList.get(j))) {
					answer = Math.max(answer, honeyList.get(i)[0] + honeyList.get(j)[0]);
				}
			}
		}
	}

	public static void dfs(int[] arr, int index, int sum, int result) {
		if (sum > c) return;

		max = Math.max(max, result);

		if (index == arr.length) return;

		dfs(arr, index + 1, sum + arr[index], result+arr[index]*arr[index]);
		dfs(arr, index + 1, sum, result);
	}

	public static boolean isPossible(int[] arr1, int[] arr2) {
		// max, i, j, j + m-1
		if (arr1[1] != arr2[1])
			return true;
		if (arr1[3] < arr2[2])
			return true;
		return false;
	}
}