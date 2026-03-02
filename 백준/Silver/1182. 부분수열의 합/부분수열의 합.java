import java.io.*;
import java.util.*;

public class Main {
	public static int n, s, count;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		nums = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
        count = 0;
		dfs(0, 0);
		System.out.print(s == 0 ? count - 1 : count);
	}

	public static void dfs(int index, int sum) {
		if (index == n) {
			if (sum == s) count++;
			return;
		}

		dfs(index + 1, sum + nums[index]);
		dfs(index + 1, sum);
	}
}