import java.io.*;
import java.util.*;
 
public class Solution {
    public static int v, e;
    public static ArrayList<Integer>[] graph;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
 
            graph = new ArrayList[v + 1];
            for (int i = 0; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                graph[b].add(a); // 나 하기 전에 해야 되는 애들을 모은다
            }
 
            // graph의 원소가 0개인 애들을 출력
            // 출력된 애는 전체에서 다 빼준다
            boolean[] visited = new boolean[v + 1];
            visited[0] = true;
            StringBuilder sb = new StringBuilder();
            while (!allVisited(visited)) {
                for (int i = 1; i <= v; i++) {
                    if (!visited[i] && graph[i].size() == 0) {
                        sb.append(i).append(" ");
                        visited[i] = true;
 
                        // 출력됐으면 빼준다
                        for (int j = 1; j <= v; j++) {
                            if (j == i) continue;
                            if (graph[j].contains(i)) {
                                graph[j].remove(Integer.valueOf(i));
                            }
                        }
                    }
                    if (allVisited(visited)) break;
                }
            }
 
            System.out.printf("#%d %s%n", tc, sb.toString());
        }
    }
 
    public static boolean allVisited(boolean[] visited) {
        for (int i = 1; i <= v; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}