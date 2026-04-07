import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() != 1) {
			q.poll();
			int a = q.poll();
			q.add(a);
		}
		System.out.println(q.peek());
	}
}