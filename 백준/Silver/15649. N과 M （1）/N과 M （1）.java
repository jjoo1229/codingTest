import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] current;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        array = new int[n + 1];
        current = new int[m];  // 결과 숫자를 담을 배열
        for (int i = 1; i <= n; i++){
            array[i] = i;
        }

        dfs(0);
        System.out.println(sb.toString());      
    }

    public static void dfs(int depth) {
        if (depth == m) {  // depth는 current에서 현재 몇 번째 칸을 채우고 있는지
            for (int val : current) {
                sb.append(val).append(" ");
            } 
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;  // 방문 처리
                current[depth] = array[i];  // 다음 깊이에 숫자 저장
                dfs(depth + 1);  // 다음 숫자를 찾으러 재귀 호출
                visited[i] = false;  // 백트래킹(원상복구)
            }
        }
    }
}