import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, k, count;
	public static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			nums = new int[n];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st2.nextToken());
			}		
			
			count = 0;
			solve(0, 0);
			System.out.printf("#%d %d%n", tc, count);
		}
	}

	public static void solve(int index, int result) {
		if (result > k) return;

		if (index == n) {
			if (result == k) count++;
			return;
		}

		solve(index + 1, result + nums[index]);
		solve(index + 1, result);
	}
}