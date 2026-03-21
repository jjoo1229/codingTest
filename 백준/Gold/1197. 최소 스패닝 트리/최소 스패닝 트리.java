import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	int a;
	int b;
	int weight;

	public Point(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Point o) {
		return weight - o.weight;
	}
}

public class Main {
	public static StringTokenizer st;
	public static int v, e;
	public static int[] parent;
	public static PriorityQueue<Point> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		q = new PriorityQueue<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.offer(new Point(a, b, c));
		}

		int weight = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (find(cur.a) != find(cur.b)) {
				union(cur.a, cur.b);
				weight += cur.weight;
			}
		}
		System.out.print(weight);
	}

	public static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);

		if (p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;
	}

	public static int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}
}