import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) return a - b;
			return Math.abs(a) - Math.abs(b);
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.add(x);
			}
		}
		System.out.print(sb.toString());
	}
}