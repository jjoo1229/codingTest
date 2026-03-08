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
		nums = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(nums);

		boolean[] visited = new boolean[n];
		comb(nums, 0, m, visited);

		System.out.println(sb.toString());
	}

	public static void comb(int[] arr, int start, int r, boolean[] visited) {
		if (r == 0) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(arr, i + 1, r - 1, visited);
				visited[i] = false;
			}
		}
	}
}