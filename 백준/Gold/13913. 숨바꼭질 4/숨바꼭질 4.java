import java.util.*;
import java.io.*;

public class Main {
	public static int n, k;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs(n);
		System.out.print(sb.toString());
	}

	public static void bfs(int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { num, 0 });
		boolean[] visited = new boolean[100001];
		visited[num] = true;
		int[] parent = new int[100001];
		parent[num] = -1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curNum = cur[0];
			int count = cur[1];

			if (curNum == k) {
				sb.append(count).append("\n");
				int[] list = new int[count];
				int i = 0;
				while (parent[curNum] != -1 && 0 <= curNum && curNum <= 100000) {
					list[i++] = parent[curNum];
					curNum = parent[curNum];
				}
				for (int j = count - 1; j >= 0; j--) {
					sb.append(list[j]).append(" ");
				}
				sb.append(k);
				return;
			}

			int plus = curNum + 1;
			if (0 <= plus && plus <= 100000 && !visited[plus]) {
				visited[plus] = true;
				parent[plus] = curNum;
				q.offer(new int[] { plus, count + 1 });
			}

			int minus = curNum - 1;
			if (0 <= minus && minus <= 100000 && !visited[minus]) {
				visited[minus] = true;
				parent[minus] = curNum;
				q.offer(new int[] { minus, count + 1 });
			}

			int twice = curNum * 2;
			if (0 <= twice && twice <= 100000 && !visited[twice]) {
				visited[twice] = true;
				parent[twice] = curNum;
				q.offer(new int[] { twice, count + 1 });
			}
		}
	}
}
