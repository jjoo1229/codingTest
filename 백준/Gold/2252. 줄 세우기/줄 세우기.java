import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static int[] indegree;
	public static ArrayList<Integer>[] graph;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		indegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			graph[a].add(b);
			indegree[b] += 1; // b로 들어오는 차수 하나 추가
		}
		bfs();
		System.out.print(sb.toString());
	}

	public static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) { // 들어오는 차수 없으면 출력
				q.offer(i);  // 큐에 넣는다
				sb.append(i).append(" ");
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int next : graph[node]) {
				indegree[next] -= 1;  // 큐에 들어간 애의 그래프 이웃들 degree 감소
				if (indegree[next] == 0) {  // 들어오는 차수 없으면 출력
					q.offer(next);
					sb.append(next).append(" ");
				}
			}
		}
	}
}