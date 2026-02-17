import java.util.*;

public class Main {
	public static int n, m;
	public static int[] nums;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
		Arrays.sort(nums);
		visited = new boolean[n];
		int[] output = new int[m];
		permutation(output, visited, 0);
	}
	
	public static void permutation(int[] output, boolean[] visited, int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = nums[i];
				permutation(output, visited, depth+1);
				visited[i] = false;
			}
		}
	}
}