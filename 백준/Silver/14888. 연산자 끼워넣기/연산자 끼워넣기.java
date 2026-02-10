import java.util.*;

public class Main {
	public static int n;
	public static int[] nums;
	public static int plus, minus, times, divide;
	public static int max, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		plus = sc.nextInt();
		minus = sc.nextInt();
		times = sc.nextInt();
		divide = sc.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(1, nums[0], plus, minus, times, divide);
		System.out.printf("%d%n%d", max, min);
	}

	public static void dfs(int index, int cur, int plus, int minus, int times, int divide) {
		if (index == n) {
			max = Math.max(max, cur);
			min = Math.min(min, cur);
			return;
		}

		if (plus > 0)
			dfs(index + 1, cur + nums[index], plus - 1, minus, times, divide);
		if (minus > 0)
			dfs(index + 1, cur - nums[index], plus, minus - 1, times, divide);
		if (times > 0)
			dfs(index + 1, cur * nums[index], plus, minus, times - 1, divide);
		if (divide > 0)
			dfs(index + 1, cur / nums[index], plus, minus, times, divide - 1);
	}
}
