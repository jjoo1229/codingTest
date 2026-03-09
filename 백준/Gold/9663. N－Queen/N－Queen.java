import java.io.*;

public class Main {
	public static int n, count;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		count = 0;
		dfs(0);
		System.out.println(count);
	}

	public static void dfs(int index) {
		if (index == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (checkCol(i) && checkLeftCross(index, i) && checkRightCross(index, i)) {
				map[index][i] = 1;
				dfs(index + 1);
				map[index][i] = 0;
			}
		}
	}

	public static boolean checkCol(int col) {
		for (int i = 0; i < n; i++) {
			if (map[i][col] == 1) return false;
		}
		return true;
	}

	public static boolean checkLeftCross(int row, int col) {
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (Math.abs(col - j) != Math.abs(row - i)) continue;
				if (map[i][j] == 1) return false;
			}
		}
		return true;
	}

	public static boolean checkRightCross(int row, int col) {
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col + 1; j < n; j++) {
				if (Math.abs(col - j) != Math.abs(row - i)) continue;
				if (map[i][j] == 1) return false;
			}
		}
		return true;
	}
}