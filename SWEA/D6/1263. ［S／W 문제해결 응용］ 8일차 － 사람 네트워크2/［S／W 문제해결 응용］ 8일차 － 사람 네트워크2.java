import java.io.*;
import java.util.*;
 
public class Solution {
    public static int t, n, answer;
    public static int[][] matrix;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                answer = Math.min(answer, bfs(i));
            }
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
 
    public static int bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        q.offer(new int[] { start, 0 });
        list.add(new int[] { start, 0 });
        visited[start] = true;
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];
            int curCount = cur[1];
             
            for (int i = 0; i < n; i++) {
                if (!visited[i] && matrix[curNode][i] == 1) {
                    visited[i] = true;
                    q.offer(new int[] { i, curCount + 1 });
                    list.add(new int[] { i, curCount + 1 });
                }
            }
        }
        int cc = 0;
        for (int[] li : list) {
            cc += li[1];
        }
        return cc;
    }
}