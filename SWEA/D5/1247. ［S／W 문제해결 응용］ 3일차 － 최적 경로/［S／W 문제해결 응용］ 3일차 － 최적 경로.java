import java.util.*;
import java.io.*;
 
public class Solution {
    public static int t, n, workX, workY, homeX, homeY, answer;
    public static int[][] customers;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            workX = Integer.parseInt(st.nextToken());
            workY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
 
            customers = new int[n][2];
            for (int i = 0; i < n; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n];
            int[] output = new int[n];
            perm(0, visited, output);
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
 
    public static void perm(int depth, boolean[] visited, int[] output) {
        if (depth == n) {
            solve(output);
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                perm(depth + 1, visited, output);
                visited[i] = false;
            }
        }
    }
 
    public static void solve(int[] output) {
        int sum = getDist(new int[] { workX, workY }, customers[output[0]]);
        if (sum >= answer) return;
         
        for (int i = 1; i < n; i++) {
            sum += getDist(customers[output[i - 1]], customers[output[i]]);
            if (sum >= answer) return;
        }
        sum += getDist(customers[output[n - 1]], new int[] { homeX, homeY });
 
        answer = Math.min(answer, sum);
    }
 
    public static int getDist(int[] n1, int[] n2) {
        int x1 = n1[0], y1 = n1[1], x2 = n2[0], y2 = n2[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}