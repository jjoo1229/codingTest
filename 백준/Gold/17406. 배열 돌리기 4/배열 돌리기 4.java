import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static int k;
	public static int[][] graph;
	public static ArrayList<int[]> infoList;
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		infoList = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			int[] info = new int[3];
			info[0] = sc.nextInt();
			info[1] = sc.nextInt();
			info[2] = sc.nextInt();
			infoList.add(info);
		}

		// 회전 연산 순서 순열로 구해서 돌리기
		int length = infoList.size();
		boolean[] visited = new boolean[length];
		int[] output = new int[length];
		min = Integer.MAX_VALUE;
		permutation(output, visited, length, 0, length);
		System.out.print(min);
	}

	public static void permutation(int[] output, boolean[] visited, int n, int depth, int r) {
		if (depth == r) {
			solve(output);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				permutation(output, visited, n, depth + 1, r);
				output[depth] = 0;
				visited[i] = false;
			}
		}
	}

	public static void solve(int[] output) {
		int[][] cloneGraph = new int[n][m]; // 회전 확인용 그래프 생성
		for (int i = 0; i < n; i++) {
			cloneGraph[i] = graph[i].clone();
		}

		for (int i : output) {
			int[] cur = infoList.get(i);
			rotate(cloneGraph, cur[0], cur[1], cur[2]);
		}
		min = Math.min(min, getMin(cloneGraph));
	}

	public static void rotate(int[][] graph, int r, int c, int s) {
		int startRow = r - s - 1;
		int startCol = c - s - 1;
		int endRow = r + s - 1;
		int endCol = c + s - 1;

		while (startRow < endRow && startCol < endCol) {
			int temp = graph[startRow][startCol];

			// 좌변: 끌어올리기
			for (int i = startRow; i < endRow; i++) {
				graph[i][startCol] = graph[i + 1][startCol];
			}
			// 밑변: 왼 <- 오
			for (int i = startCol; i < endCol; i++) {
				graph[endRow][i] = graph[endRow][i + 1];
			}
			// 우변: 끌어내리기
			for (int i = endRow; i > startRow; i--) {
				graph[i][endCol] = graph[i - 1][endCol];
			}
			// 윗변: 왼 -> 오
			for (int i = endCol; i > startCol + 1; i--) {
				graph[startRow][i] = graph[startRow][i - 1];
			}
			graph[startRow][startCol + 1] = temp;

			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
	}

	public static int getMin(int[][] graph) {
		int arrMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += graph[i][j];
			}
			arrMin = Math.min(arrMin, sum);
		}
		return arrMin;
	}
}