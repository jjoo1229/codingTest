import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static int[] nums;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(nums);
		int[] output = new int[m];
		perm(0, output);
		System.out.print(sb.toString());
	}

	public static void perm(int depth, int[] output) {
		if (depth == m) {
			print(output);
			return;
		}

		for (int i = 0; i < n; i++) {
			output[depth] = nums[i];
			perm(depth + 1, output);
		}
	}

	public static void print(int[] output) {
		for (int i = 0; i < m; i++) {
			sb.append(output[i]).append(" ");
		}
		sb.append("\n");
	}
}
