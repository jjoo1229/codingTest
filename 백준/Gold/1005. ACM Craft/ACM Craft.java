import java.io.*;
import java.util.*;

public class Main {
	public static int tc, n, k, w, sum;
	public static int[] time;
	public static int[] havetoBuild;
	public static List<Integer>[] nextGraph;
	public static List<Integer>[] preGraph;
	public static int[] resultTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			time = new int[n + 1];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				time[j] = Integer.parseInt(st2.nextToken());
			}

			nextGraph = new ArrayList[n + 1]; // 다음에 어느 건물 지을지 저장
			preGraph = new ArrayList[n + 1]; // 이 건물 짓기 전에 어느 건물 지었는지 저장
			for (int j = 0; j <= n; j++) {
				nextGraph[j] = new ArrayList<>();
				preGraph[j] = new ArrayList<>();
			}

			for (int j = 0; j < k; j++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st3.nextToken());
				int b = Integer.parseInt(st3.nextToken());
				// 그래프에 저장
				nextGraph[a].add(b);
				preGraph[b].add(a);
			}

			havetoBuild = new int[n + 1]; // 각 건물의 이전에 지어졌어야 하는 건물 개수 저장
			for (int j = 0; j < preGraph.length; j++) {
				havetoBuild[j] = preGraph[j].size();
			}

			w = Integer.parseInt(br.readLine());
			bfs();
			System.out.println(resultTime[w]);
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		resultTime = new int[n + 1]; // 각 건물을 짓는데 걸리는 최소 시간 저장

		for (int i = 1; i <= n; i++) {
			if (havetoBuild[i] == 0) {
				q.add(i);
				resultTime[i] = time[i];
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : nextGraph[cur]) {
				// 저장된 resultTime값과, (현재 보고있는 건물의 resultTime + 지금 건물 짓는 데에 걸리는 시간)을 비교해서 더 큰 값으로 저장
				// -> 하나의 next에 여러 개의 cur(next 이전 건물)이 올 수도 있음. 매번 더 큰 값으로 업데이트.
				resultTime[next] = Math.max(resultTime[next], resultTime[cur] + time[next]);
				havetoBuild[next]--;

				if (havetoBuild[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}