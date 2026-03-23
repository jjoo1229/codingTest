import java.io.*;
import java.util.*;

public class Main {
	public static int[][] map;
	public static ArrayList<int[]> zeros;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		zeros = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeros.add(new int[] { i, j });
				}
			}
		}

		dfs(0);
	}

	public static boolean checkRow(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkCol(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num) {
				return false;
			}
		}
		return true;
	}

	public static boolean check3By3(int x, int y, int num) {
		// 012 345 678로 나눠야 함. n/3이 0 1 2인 것
		int nx = x / 3;
		int ny = y / 3;
		for (int i = nx * 3; i < nx * 3 + 3; i++) {
			for (int j = ny * 3; j < ny * 3 + 3; j++) {
				if (map[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void dfs(int index) {
		if (index == zeros.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);  // 찾는 순간 끝내버림
		}

		int x = zeros.get(index)[0];
		int y = zeros.get(index)[1];

		for (int i = 1; i <= 9; i++) {
			if (checkRow(x, y, i) && checkCol(x, y, i) && check3By3(x, y, i)) {
				map[x][y] = i;
				dfs(index + 1);
				map[x][y] = 0;
			}
		}
	}
}