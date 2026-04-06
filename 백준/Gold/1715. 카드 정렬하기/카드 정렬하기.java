import java.util.*;
import java.io.*;

public class Main {
	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int count = 0;
		while (q.size() > 1) {
			int num1 = q.poll();
			int num2 = q.poll();
			count += num1 + num2;
			q.add(num1 + num2);
		}
		System.out.println(count);
	}
}