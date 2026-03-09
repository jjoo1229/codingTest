import java.io.*;
import java.util.*;
 
public class Solution {
    public static int t, n ;
    public static int[][] islands;
    public static double e;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            islands = new int[n][2];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                islands[i][0] = Integer.parseInt(st.nextToken());
            }
 
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                islands[i][1] = Integer.parseInt(st2.nextToken());
            }
 
            e = Double.parseDouble(br.readLine());
 
            System.out.printf("#%d %d%n", tc, Math.round(e * prim()));
        }
    }
 
    public static double prim() {
        double[] minDist = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minDist, Double.MAX_VALUE); // 거리 배열을 무한대로 초기화
 
        double totalWeight = 0;
        minDist[0] = 0; // 0번 정점부터 시작
 
        for (int i = 0; i < n; i++) {
            double min = Double.MAX_VALUE;
            int curr = -1;
 
            // 방문하지 않은 정점 중 minDist가 가장 작은 정점 찾기
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < min) {
                    min = minDist[j];
                    curr = j;
                }
            }
 
            if (curr == -1) break; // 연결된 점이 더 이상 없음
 
            visited[curr] = true;
            totalWeight += min;
 
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    long dist = getDist(islands[curr][0], islands[curr][1], islands[next][0], islands[next][1]);
                    if (dist < minDist[next]) {
                        minDist[next] = dist;
                    }
                }
            }
        }
        return totalWeight;
    }
 
    public static long getDist(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}