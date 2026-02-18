import java.util.*;

class Solution {
	public static int n;
	public static int[][] map;
	public static ArrayList<int[]> cores;
	public static ArrayList<int[]> answer;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			map = new int[n][n];
			cores = new ArrayList<>();
			answer = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1 && i != 0 && i != n-1 && j != 0 && j != n-1) // 가장자리에 있는 애들은 제외
						cores.add(new int[] { i, j });
				}
			}
			
			dfs(map, 0, 0, 0);
			answer.sort((a,b)-> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
			
			int ans = 0;
			if (answer.size() != 0) ans = answer.get(0)[1];
			System.out.printf("#%d %d%n", test_case, ans);
		}
	}

	public static void dfs(int[][] map, int index, int coreNum, int sum) {
		if (index == cores.size()) {
			answer.add(new int[] {coreNum, sum});
			return;
		}
		
		int[] cur = cores.get(index);
		int curX = cur[0];
		int curY = cur[1];

		// 위로 올라가면서 1이 있는지 찾음
		boolean upPossible = true;
		for (int i = curX - 1; i >= 0; i--) {
			if (map[i][curY] == 1) {
				upPossible = false; // 1 발견하면 안 됨, 중단
				break;
			}
		}
		if (upPossible) { // 위에 가능하면 위쪽 다 1로 바꾸고, 다음 dfs 돌리기
			int[][] cloneMap = new int[n][n];
			for (int i = 0; i < n; i++)
				cloneMap[i] = map[i].clone();

			for (int i = curX - 1; i >= 0; i--)
				cloneMap[i][curY] = 1;
			dfs(cloneMap, index + 1, coreNum + 1, sum + curX);
		}
		
		// 아래로 내려가면서 1이 있는지 찾음
		boolean downPossible = true;
		for (int i = curX + 1; i < n; i++) {
			if (map[i][curY] == 1) {
				downPossible = false; // 1 발견하면 안 됨, 중단
				break;
			}
		}
		if (downPossible) { // 아래에 가능하면 아래쪽 다 1로 바꾸고, 다음 dfs 돌리기
			int[][] cloneMap = new int[n][n];
			for (int i = 0; i < n; i++)
				cloneMap[i] = map[i].clone();

			for (int i = curX + 1; i < n; i++)
				cloneMap[i][curY] = 1;
			dfs(cloneMap, index + 1, coreNum + 1, sum + n - (curX + 1));
		}

		// 왼쪽으로 가면서 1이 있는지 찾음
		boolean leftPossible = true;
		for (int i = curY - 1; i >= 0; i--) {
			if (map[curX][i] == 1) {
				leftPossible = false; // 1 발견하면 안 됨, 중단
				break;
			}
		}
		if (leftPossible) { // 아래에 가능하면 아래쪽 다 1로 바꾸고, 다음 dfs 돌리기
			int[][] cloneMap = new int[n][n];
			for (int i = 0; i < n; i++)
				cloneMap[i] = map[i].clone();

			for (int i = curY - 1; i >= 0; i--)
				cloneMap[curX][i] = 1;
			dfs(cloneMap, index + 1, coreNum + 1, sum + curY);
		}

		// 오른쪽으로 가면서 1이 있는지 찾음
		boolean rightPossible = true;
		for (int i = curY + 1; i < n; i++) {
			if (map[curX][i] == 1) {
				rightPossible = false; // 1 발견하면 안 됨, 중단
				break;
			}
		}
		if (rightPossible) { // 아래에 가능하면 아래쪽 다 1로 바꾸고, 다음 dfs 돌리기
			int[][] cloneMap = new int[n][n];
			for (int i = 0; i < n; i++)
				cloneMap[i] = map[i].clone();

			for (int i = curY + 1; i < n; i++)
				cloneMap[curX][i] = 1;
			dfs(cloneMap, index + 1, coreNum + 1, sum + n - (curY + 1));
		}
		
		dfs(map, index + 1, coreNum, sum);  // 연결 안 되면 그냥 패스
	}
}