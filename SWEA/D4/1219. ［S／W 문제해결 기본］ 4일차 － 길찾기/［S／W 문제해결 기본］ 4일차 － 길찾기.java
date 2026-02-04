import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            int num = sc.nextInt();
            
            List<Integer>[] graph = new ArrayList[100];
            for (int i = 0; i < 100; i++) graph[i] = new ArrayList<>();
            
            for (int i = 0; i < num; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
            }
            int answer = dfs(graph);
            System.out.printf("#%d %d%n", test_case, answer);
		}
	}

    public static int dfs(List<Integer>[] graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (x == 99) return 1;
            for (int next : graph[x]) {
                stack.push(next);
            }
        }
        return 0;
    }
}