import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, r, u, v;
	public static ArrayList<Integer>[] graph;
	public static int turn = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st2.nextToken());
			v = Integer.parseInt(st2.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		int[] visited = new int[n + 1];
		dfs(r, visited);

		for (int i = 1; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}

	public static void dfs(int node, int[] visited) {
		visited[node] = turn++;

		for (int neighbor : graph[node]) {
			if (visited[neighbor] == 0) { // 방문한 적 없으면
				dfs(neighbor, visited);
			}
		}
	}
}
