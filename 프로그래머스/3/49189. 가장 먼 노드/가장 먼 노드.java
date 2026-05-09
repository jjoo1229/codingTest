import java.util.*;

class Solution {
    public static int max, answer;
    public static int[] distArr;
    public static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        max = Integer.MIN_VALUE;
        answer = 0;
        graph = new ArrayList[n + 1];
        distArr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int n1 = e[0], n2 = e[1];
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        bfs(n);
        for (int dist : distArr) {
            if (dist == max) answer++;
        }
        return answer;
    }
    
    public static void bfs(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new int[]{1,0});
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];
            max = Math.max(max, dist);
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    distArr[next] = dist + 1;
                    visited[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }
    }
}