import java.io.*;
import java.util.*;

public class Main {
	public static int n, m, answer;
	public static StringTokenizer st;
	public static int[][] map;
	public static ArrayList<int[]> home;
	public static ArrayList<int[]> chickens;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		home = new ArrayList<>();
		chickens = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		boolean[] visited = new boolean[chickens.size()];
		dfs(0, visited, m);
		System.out.print(answer);
	}

	public static void dfs(int start, boolean[] visited, int r) {
		if (r == 0) {
			int[] list = new int[m];
			int index = 0;
			for (int i = 0; i < chickens.size(); i++) {
				if (visited[i]) {
					list[index++] = i;
				}
			}
			answer = Math.min(answer, getDist(list));
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, visited, r - 1);
				visited[i] = false;
			}
		}
	}

	public static int getDist(int[] list) { // 집과 가장 가까운 치킨집 사이의 거리
		int cityDist = 0;
		for (int i = 0; i < home.size(); i++) {
			int x1 = home.get(i)[0];
			int y1 = home.get(i)[1];

			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < list.length; j++) {
				int x2 = chickens.get(list[j])[0];
				int y2 = chickens.get(list[j])[1];

				dist = Math.min(dist, Math.abs(x1 - x2) + Math.abs(y1 - y2));
			}
			cityDist += dist;
		}
		return cityDist;
	}
}