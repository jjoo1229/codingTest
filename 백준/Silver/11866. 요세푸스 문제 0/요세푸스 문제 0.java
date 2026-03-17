import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> nums = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		ArrayList<Integer> list = new ArrayList<>();
		while (!nums.isEmpty()) {
			for (int i = 1; i < k; i++) {
				int num = nums.poll();
				nums.add(num);
			}
			if (!nums.isEmpty()) list.add(nums.poll());
		}

		StringBuilder sb = new StringBuilder("<");
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i)).append(", ");
		}
		sb.append(list.get(list.size() - 1)).append(">");
		
		System.out.print(sb.toString());
	}
}