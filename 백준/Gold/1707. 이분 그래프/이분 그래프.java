import java.io.*;
import java.util.*;

public class Main {
	public static int k, v, e;
	public static ArrayList<Integer>[] graph;
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= k; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			graph = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				graph[node1].add(node2);
				graph[node2].add(node1);
			}
			sb.append(solve()).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static String solve() {
		int[] groups = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			if (groups[i] == 0) {
				if (!check(i, groups)) {
					return "NO";
				}
			}
		}
		return "YES";
	}

	public static boolean check(int i, int[] groups) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		groups[i] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int neighbor : graph[cur]) { // curNode의 이웃이
				if (groups[neighbor] == 0) { // 방문한 적 없으면 무조건 반대에 넣어버리기
					groups[neighbor] = (groups[cur] == 1) ? 2 : 1;
					q.offer(neighbor);
				} else { // 이미 방문했는데 curNode랑 같은 그룹이면 땡
					if (groups[neighbor] == groups[cur]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}