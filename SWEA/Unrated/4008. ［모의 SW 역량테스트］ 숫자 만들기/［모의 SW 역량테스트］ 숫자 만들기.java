import java.util.*;

public class Solution {
	public static int n;
	public static int[] nums;
	public static int max;
	public static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			n = sc.nextInt();

			int plusNum = sc.nextInt();
			int minusNum = sc.nextInt();
			int timesNum = sc.nextInt();
			int divideNum = sc.nextInt();

			nums = new int[n];
			for (int i = 0; i < n; i++)
				nums[i] = sc.nextInt();

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			dfs(1, nums[0], plusNum, minusNum, timesNum, divideNum);

			System.out.printf("#%d %d%n", test_case, max - min);
		}
	}

	// index: 사용할 숫자의 위치, cur: 지금까지 계산된 값
	public static void dfs(int index, int cur, int plusNum, int minusNum, int timesNum, int divideNum) {
		if (index == n) { // 모든 숫자를 다 사용한 경우
			max = Math.max(max, cur);
			min = Math.min(min, cur);
			return;
		}

		// 각 연산자가 남아있을 경우 계산한 값을 cur 위치에 넣어 재귀 호출
		if (plusNum > 0) {
			dfs(index + 1, cur + nums[index], plusNum - 1, minusNum, timesNum, divideNum);
		}
		if (minusNum > 0) {
			dfs(index + 1, cur - nums[index], plusNum, minusNum - 1, timesNum, divideNum);
		}
		if (timesNum > 0) {
			dfs(index + 1, cur * nums[index], plusNum, minusNum, timesNum - 1, divideNum);
		}
		if (divideNum > 0) {
			dfs(index + 1, cur / nums[index], plusNum, minusNum, timesNum, divideNum - 1);
		}
	}
}