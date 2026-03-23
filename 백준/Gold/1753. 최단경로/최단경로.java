import java.io.*;
import java.util.*;

public class Main {
	public static int v, e, k;
	public static StringTokenizer st;
	public static int[] dist;
	public static ArrayList<int[]>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		dist = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			if (i == k) continue;
			else dist[i] = Integer.MAX_VALUE;
		}
		
		graph = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] { b, w });
//			graph[b].add(new int[] { a, w });  // 단방향임
		}
		
		dijkstra();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void dijkstra() {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		q.add(new int[] { k, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curNode = cur[0];
			int curWeight = cur[1];

			for (int[] neighbor : graph[curNode]) {
				int nNode = neighbor[0];
				int nWeight = neighbor[1];
				
				if (dist[nNode] > curWeight + nWeight) { // 지금까지 거리랑 새로 보는 거리랑 비교해서 더 작으면
					dist[nNode] = curWeight + nWeight;
					q.add(new int[] { nNode, curWeight + nWeight });
				}
			}
		}
	}
}
