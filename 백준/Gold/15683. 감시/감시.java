import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static int[][] map;
	public static ArrayList<int[]> CCTV;
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		CCTV = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) {
					CCTV.add(new int[] { i, j, map[i][j] });  // CCTV 위치, 타입 저장
				}
			}
		}

		min = Integer.MAX_VALUE;
		dfs(0, map);
		System.out.print(min);
	}

	public static void dfs(int index, int[][] map) {
		if (index == CCTV.size()) {
			min = Math.min(min, countNum(map));
			return;
		}

		int[] cur = CCTV.get(index); // 현재 CCTV 정보
		for (int[] directions : getDirections(cur[2])) {
			int[][] nMap = copyMap(map); // 현재 상태의 맵 복사
			for (int d : directions) {
				// 감시 영역 표시
				watch(cur[0], cur[1], d, nMap);
			}
			dfs(index + 1, nMap);
		}
	}

	public static int[][] getDirections(int type) {
		switch (type) {
		case (1):
			return new int[][] { { 0 }, { 1 }, { 2 }, { 3 } };
		case (2):
			return new int[][] { { 0, 2 }, { 1, 3 } };
		case (3):
			return new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
		case (4):
			return new int[][] { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } };
		case (5):
			return new int[][] { { 0, 1, 2, 3 } };
		default:
			return new int[][] {};
		}
	}

	public static void watch(int x, int y, int dir, int[][] map) {
		int nx = x, ny = y;
		if (dir == 0) {  // 상
			nx--;
			while (nx >= 0) {
				if (map[nx][y] == 6) break;
				map[nx][y] = -1;
				nx--;
			}
		} else if (dir == 1) {  // 우
			ny++;
			while (ny < m) {
				if (map[x][ny] == 6) break;
				map[x][ny] = -1;
				ny++;
			}
		} else if (dir == 2) {  // 하
			nx++;
			while (nx < n) {
				if (map[nx][y] == 6) break;
				map[nx][y] = -1;
				nx++;
			}
		} else if (dir == 3) {  // 좌
			ny--;
			while (ny >= 0) {
				if (map[x][ny] == 6) break;
				map[x][ny] = -1;
				ny--;
			}
		}
	}

	public static int[][] copyMap(int[][] map) {
		int[][] nMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			nMap[i] = map[i].clone();
		}
		return nMap;
	}

	public static int countNum(int[][] map) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}