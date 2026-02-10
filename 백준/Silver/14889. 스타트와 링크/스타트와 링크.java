import java.util.*;

public class Main {
	public static int n;
	public static int[][] map;
	public static int[] nums;  // 1 ~ n까지 숫자 배열
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		boolean[] visited = new boolean[n];

		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		min = Integer.MAX_VALUE;
		combination(nums, visited, 0, n / 2);
		System.out.println(min);
	}

	public static void combination(int[] arr, boolean[] visited, int start, int r) {
		int teamA = 0;
		int teamB = 0;

		if (r == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					if (visited[i] && visited[j])  // 뽑은 애면 스타트 팀에 점수 더하기
						teamA += map[i][j];
					else if (!visited[i] && !visited[j])  // 안 뽑은 애면 링크 팀에 점수 더하기
						teamB += map[i][j];
				}
			}
			min = Math.min(min, Math.abs(teamA - teamB));
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, r - 1);
			visited[i] = false;
		}
	}
}