class Solution {
    public static int n, answer;
    // 최대한 많이 탐험, 피로도 k, [최소필요피로도, 소모피로도]
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        
        answer = 0;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        perm(0, output, visited, k, dungeons);
        return answer;
    }
    
    // 순열로 방문 순서 구하기
    public static void perm(int depth, int[] output, boolean[] visited, int k, int[][] dungeons) {
        if (depth == n) {
            answer = Math.max(answer, solve(output, k, dungeons));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                perm(depth + 1, output, visited, k, dungeons);
                visited[i] = false;
                
            }
        }
    }
    
    public static int solve(int[] output, int k, int[][] dungeons) {
        int energy = k;
        int count = 0;
        // output은 방문순서를 담은 배열
        for (int i = 0; i < n; i++) {
            int index = output[i];
            if (energy >= dungeons[index][0]){
                energy -= dungeons[index][1];
                count++;
            }
        }
        return count;
    }
}