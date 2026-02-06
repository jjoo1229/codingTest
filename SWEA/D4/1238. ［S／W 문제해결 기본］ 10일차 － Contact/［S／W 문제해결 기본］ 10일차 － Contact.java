import java.util.*;

class Solution {
    static int start;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int len = sc.nextInt();
            start = sc.nextInt();
            
            List<Integer>[] list = new ArrayList[101];
            for (int i = 0; i <= 100; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < len / 2; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (!list[a].contains(b)) {
                    list[a].add(b);
                }
            }
            System.out.printf("#%d %d%n", test_case, bfs(list));
        }
    }

    public static int bfs(List<Integer>[] list) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> al = new ArrayList<>();
        boolean[] visited = new boolean[101];
        q.offer(new int[]{start, 0});
        al.add(new int[]{start, 0});
        visited[start] = true;
        int max = Integer.MIN_VALUE;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int count = cur[1];
            max = Math.max(max, count);
            
            for (int e : list[x]) {
                if (!visited[e]) {
                    visited[e] = true;
                    q.offer(new int[]{e, count + 1});
                    al.add(new int[]{e, count + 1});
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int[] a : al) {
            if (a[1] == max) answer = Math.max(answer, a[0]);
        }
        return answer;
    }
}