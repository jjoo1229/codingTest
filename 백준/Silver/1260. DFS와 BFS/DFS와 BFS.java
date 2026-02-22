import java.util.*;
import java.io.*;

public class Main {
	public static int n, m, v;
	public static List<Integer>[] graph;
	public static List<Integer> dfsList = new ArrayList<>();
	public static List<Integer> bfsList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1]; // 인덱스 0은 사용하지 않음
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for (List<Integer> g : graph) {
			Collections.sort(g);
		}

		boolean[] dfsVisited = new boolean[n + 1];
		dfs(dfsVisited, v);
		bfs();

		StringBuilder sb = new StringBuilder();
		for (Integer d : dfsList) {
			sb.append(d);
			sb.append(" ");
		}
		sb.append("\n");
		for (Integer b : bfsList) {
			sb.append(b);
			sb.append(" ");
		}
		System.out.print(sb);
	}

	public static void dfs(boolean[] visited, int node) {
		visited[v] = true;
		dfsList.add(node);

		for (int neighbor : graph[node]) {
			if (!visited[neighbor]) {
				visited[neighbor] = true;
				dfs(visited, neighbor);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		visited[v] = true;
		q.add(v);
		bfsList.add(v);

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int neighbor : graph[node]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					q.add(neighbor);
					bfsList.add(neighbor);
				}
			}
		}
	}
}
