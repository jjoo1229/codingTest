import java.io.*;
import java.util.*;

public class Main {
	public static int t, n, homeX, homeY, finalX, finalY;
	public static boolean st;
	public static int[][] cvs;
	public static ArrayList<int[]> endCVS;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			cvs = new int[n][2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				cvs[i][0] = Integer.parseInt(st2.nextToken());
				cvs[i][1] = Integer.parseInt(st2.nextToken());
			}

			StringTokenizer st3 = new StringTokenizer(br.readLine());
			finalX = Integer.parseInt(st3.nextToken());
			finalY = Integer.parseInt(st3.nextToken());

			sb.append(solve()).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	public static String solve() {
		if (getDist(homeX, homeY, finalX, finalY) <= 1000) return "happy";

		ArrayList<int[]> startCVS = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (getDist(homeX, homeY, cvs[i][0], cvs[i][1]) <= 1000) {
				startCVS.add(new int[] { i, cvs[i][0], cvs[i][1] });
			}
		}
		if (startCVS.size() == 0) return "sad";

		endCVS = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (getDist(finalX, finalY, cvs[i][0], cvs[i][1]) <= 1000) {
				endCVS.add(new int[] { i, cvs[i][0], cvs[i][1] });
			}
		}
		if (endCVS.size() == 0) return "sad";

		boolean[] visited = new boolean[n];
		st = false;
		for (int i = 0; i < startCVS.size(); i++) {
			dfs(startCVS.get(i)[0], startCVS.get(i)[1], startCVS.get(i)[2], visited);
			if (st) return "happy";
		}
		
		for (int i = 0; i < endCVS.size(); i++) {
			if (visited[endCVS.get(i)[0]]) return "happy";
		}

		return "sad";
	}

	public static void dfs(int index, int x, int y, boolean[] visited) {
		if (getDist(x, y, finalX, finalY) <= 1000) {
			st = true;
			return;
		}

		visited[index] = true;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (getDist(x, y, cvs[i][0], cvs[i][1]) <= 1000) {
					dfs(i, cvs[i][0], cvs[i][1], visited);
				}
			}
		}
	}
}