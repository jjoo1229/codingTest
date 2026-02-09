import java.util.*;

// 한 계단씩 올라가는 대신, 8칸, 4칸, 2칸, 1칸씩 크게크게 점프해서 효율적으로 두 노드의 공통조상을 찾는 코드
class Solution {
	public static List<List<Integer>> tree;
	public static int[][] parents; // 각 노드의 부모 노드 정보
	public static int[] depths; // 각 노드의 깊이 정보
	public static boolean[] visited;
	public static int[] subTreeSize; // 각 노드의 서브트리 크기

	public Solution(List<List<Integer>> tree) {
		this.tree = tree;
	}

	public void clear(int n, int h) {
		depths = new int[n + 1]; // 각 노드의 깊이 저장
		visited = new boolean[n + 1];
		parents = new int[n + 1][h]; // parents[node][k]는 node의 2^k번째 조상
		subTreeSize = new int[n + 1];
	}

	public static int getHeight(int n) {
		return (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
	}

	// 각 노드의 깊이를 저장하고, 현재 노드의 바로 윗부모와 연결하는 메서드
	public static int dfs(int curr, int depth) {
		visited[curr] = true;
		depths[curr] = depth; // 현재 노드의 깊이
		subTreeSize[curr] = 1; // 자기 자신 1개로 초기화

		for (int next : tree.get(curr)) {
			if (!visited[next]) {
				parents[next][0] = curr; // next의 2^0(=1)번째 부모가 curr
				subTreeSize[curr] += dfs(next, depth + 1);
			}
		}
		return subTreeSize[curr];
	}

	// 희소 배열 채우기
	public static void setParent(int n, int h) {
		for (int j = 1; j < h; j++) {
			for (int i = 1; i <= n; i++) {
				// i의 2^j번째 부모 = i의 2^(j-1)번째 부모의 2^(j-1)번째 부모
				parents[i][j] = parents[parents[i][j - 1]][j - 1];
			}
		}
	}

	public static int Solution(int a, int b, int h) {
		// 두 노드의 높이 맞추기
		if (depths[a] < depths[b]) { // 항상 a를 더 깊은 노드로 설정
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = h - 1; i >= 0; i--) { // 깊이 차이가 2^i보다 크면 그만큼 위로 점프
			if (depths[a] - depths[b] >= (1 << i)) {
				a = parents[a][i];
			}
		}
		if (a == b)
			return a;

		// 동시에 위로 올라가며 공통조상 직전까지 가기
		for (int i = h - 1; i >= 0; i--) {
			if (parents[b][i] != parents[a][i]) { // 부모가 다르다면 아직 공통 조상까지 못 갔으니
				a = parents[a][i]; // 둘 다 2^i만큼 위로 이동
				b = parents[b][i];
			}
		}
		// 루프가 끝나면 둘은 공통조상 바로 밑에 있게 되므로, 한 칸 위가 공통조상
		return parents[a][0];
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			List<List<Integer>> tree = new ArrayList<>();

			int v = sc.nextInt();
			int e = sc.nextInt();

			for (int i = 0; i <= v; i++)
				tree.add(new ArrayList<>());

			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				tree.get(a).add(b);
			}
			Solution sa = new Solution(tree);
			int h = sa.getHeight(v);
			sa.clear(v, h);
			sa.dfs(1, 0); // 1. 각 노드의 깊이를 설정한다
			sa.setParent(v, h); // 2. 모든 노드의 2^i번째 부모노드를 찾는다
			int lca = sa.Solution(node1, node2, h); // 3. 최소 공통 조상을 찾을 두 노드의 깊이를 동일하게 맞추고 공통 조상을 찾는다
			System.out.printf("#%d %d %d%n", test_case, lca, sa.subTreeSize[lca]);
		}
	}
}