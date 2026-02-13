import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static int n, x;
	public static int[][] map;
	public static int[][] newMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer strtk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(strtk.nextToken());
			x = Integer.parseInt(strtk.nextToken());

			map = new int[n][n];
			newMap = new int[n][n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					newMap[j][i] = map[i][j];
				}
			}

			int answer = 0;
			for (int i = 0; i < n; i++) {
				if (isPossible(map[i])) answer++;
				if (isPossible(newMap[i])) answer++;
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	public static boolean isPossible(int[] row) {
		boolean[] used = new boolean[n]; // 경사로 설치 여부 체크

		// 전체 조건을 하나의 for문 안에서 처리
		for (int i = 0; i < n - 1; i++) {
			if (row[i + 1] == row[i])
				continue;

			if (Math.abs(row[i + 1] - row[i]) > 1)
				return false;

			if (Math.abs(row[i + 1] - row[i]) != 0) { // 차이가 날 때
				if (row[i] > row[i + 1]) { // 작아지는 경우
					for (int j = i + 1; j <= i + x; j++) {
						if (j >= n || row[j] != row[i + 1] || used[j]) { // 범위를 벗어나거나 높이가 달라지거나 이미 경사로가 있으면 안 됨
							return false;
						}
						used[j] = true; // 경사로 설치
					}
				} else { // 커지는 경우
					for (int j = i; j > i - x; j--) {
						if (j < 0 || row[j] != row[i] || used[j]) { // 범위를 벗어나거나 높이가 달라지거나 이미 경사로가 있으면 안 됨
							return false;
						}
						used[j] = true; // 경사로 설치
					}
				}
			}
		}
		return true;
	}
}