// MST(크루스칼 알고리즘) 활용
import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int weight;

	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		return weight - e.weight;
	}
}

public class Main {
	public static StringTokenizer st;
	public static int n, m;
	public static PriorityQueue<Edge> q;
	public static int[] parent;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>();
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.offer(new Edge(a, b, c));
		}

		// 사이클 확인(union-find)
		int weight = 0;
		list = new ArrayList<>();
		while (!q.isEmpty()) {
			Edge cur = q.poll(); // weight이 가장 작은 간선

			// 부모 노드가 다를 때만 (사이클 X)
			if (find(cur.v1) != find(cur.v2)) {
				union(cur.v1, cur.v2);
				list.add(cur.weight);
				weight += cur.weight;
			}
		}

		System.out.print(weight - list.get(list.size() - 1));
	}

	// 합치기
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;
	}

	// 부모 노드 찾기
	public static int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}
}