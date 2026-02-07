import java.util.*;

public class Main {
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<int[]> stack = new Stack<>();
		map = new int[1001][1001];

		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			stack.push(new int[] { x, y, w, h });
		}

		Stack<Integer> result = new Stack<>();
		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			result.push(makeSquare(cur));
		}

		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}

	public static int makeSquare(int[] value) {
		int count = 0;

		int x = value[0];
		int y = value[1];
		int w = value[2];
		int h = value[3];

		for (int i = 1000 - y; i > 1000 - y - h; i--) {
			for (int j = x; j < x + w; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					count++;
				}
			}
		}
		return count;
	}
}