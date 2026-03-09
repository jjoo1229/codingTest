import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				pq.add(x);
			}
		}

		for (int i = 1; i < n; i++) {
			pq.poll();
		}
		System.out.println(pq.peek());
	}
}
