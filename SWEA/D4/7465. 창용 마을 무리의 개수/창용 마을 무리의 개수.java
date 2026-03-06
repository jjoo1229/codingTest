import java.io.*;
import java.util.*;
 
public class Solution {
    public static int t, n, m, answer;
    public static ArrayList<Integer>[] graph;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
 
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
 
            for (int i = 0; i < m; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
 
            answer = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    bfs(i, visited);
                    answer++;
                }
            }
 
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
 
    public static void bfs(int b, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(b);
        visited[b] = true;
 
        while (!q.isEmpty()) {
            int cur = q.poll();
 
            for (int neighbor : graph[cur]) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}