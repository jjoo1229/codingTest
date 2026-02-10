import java.util.*;

public class Solution {
	public static int answer;
	public static int dayCost;
	public static int monthCost;
	public static int threeMonthCost;
	public static int yearCost;
	public static int[] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int test_case = 1; test_case <= t; test_case++) {
			dayCost = sc.nextInt();
			monthCost = sc.nextInt();
			threeMonthCost = sc.nextInt();
			yearCost = sc.nextInt();

			plan = new int[13];
			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}
			answer = yearCost;
			dfs(1, 0);
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	public static void dfs(int month, int sum) {
		if (month > 12) {
			answer = Math.min(answer, sum);
			return;
		}

		dfs(month + 1, sum + plan[month] * dayCost); // 1일권 쓰는 경우
		dfs(month + 1, sum + monthCost); // 1달권 쓰는 경우
		dfs(month + 3, sum + threeMonthCost); // 3달권 쓰는 경우
	}
}