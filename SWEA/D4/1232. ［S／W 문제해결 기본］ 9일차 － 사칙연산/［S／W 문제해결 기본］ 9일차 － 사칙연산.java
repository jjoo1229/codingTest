import java.util.*;

class Node {
	int idx;
	String value;
	Node left;
	Node right;

	public Node(int idx, String value) {
		this.idx = idx;
		this.value = value;
	}

	public Node(int idx, String value, Node left, Node right) {
		this.idx = idx;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	Node root;

	public static double postOrder(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return Double.parseDouble(node.value);

		double a = postOrder(node.left);
		double b = postOrder(node.right);
		String op = node.value;

		switch (op) {
		case "+": return a + b;
		case "-": return a - b;
		case "*": return a * b;
		case "/": return a / b;
		default: return 0.0;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			Node[] nodes = new Node[n + 1];

			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node(i, "");
			}

			sc.nextLine();

			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				String[] arr = line.split(" ");

				int idx = Integer.parseInt(arr[0]);
				nodes[idx].value = arr[1];
				int left = 0, right = 0;
				if (arr.length == 4) {
					left = Integer.parseInt(arr[2]);
					right = Integer.parseInt(arr[3]);
				}

				if (left > 0)
					nodes[idx].left = nodes[left];
				if (right > 0)
					nodes[idx].right = nodes[right];
			}
			int answer = (int) postOrder(nodes[1]);
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}