import java.util.*;

class Node {
	int idx;
	char value;
	Node left;
	Node right;

	public Node(int idx, char value) {
		this.idx = idx;
		this.value = value;
		left = null;
		right = null;
	}

	public Node(int idx, char value, Node left, Node right) {
		this.idx = idx;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	Node root;

	public static String inOrder(Node node) {
		if (node == null)
			return "";
		String answer = "";
		answer = inOrder(node.left) + node.value + inOrder(node.right);
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			Node[] nodes = new Node[n + 1];
			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node(i, ' ');
			}
			sc.nextLine();

			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				String[] arr = line.split(" ");

				int idx = Integer.parseInt(arr[0]);
				char value = arr[1].charAt(0);
				int left = 0, right = 0;
				if (arr.length == 3) {
					left = Integer.parseInt(arr[2]);
				} else if (arr.length == 4) {
					left = Integer.parseInt(arr[2]);
					right = Integer.parseInt(arr[3]);
				}
				nodes[idx].value = value;
				if (left > 0)
					nodes[idx].left = nodes[left];
				if (right > 0)
					nodes[idx].right = nodes[right];
			}
			System.out.printf("#%d %s%n", test_case, inOrder(nodes[1]));
		}
	}
}