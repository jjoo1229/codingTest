import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int maxFlies = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 1. + 모양 스프레이
                    int sumPlus = map[i][j];
                    int[] dxP = {-1, 1, 0, 0};
                    int[] dyP = {0, 0, -1, 1};
                    
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxP[d] * k;
                            int ny = j + dyP[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) sumPlus += map[nx][ny];
                        }
                    }

                    // 2. X 모양 스프레이
                    int sumCross = map[i][j];
                    int[] dxC = {-1, -1, 1, 1};
                    int[] dyC = {-1, 1, -1, 1};
                    
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxC[d] * k;
                            int ny = j + dyC[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) sumCross += map[nx][ny];
                        }
                    }
                    
                    maxFlies = Math.max(maxFlies, Math.max(sumPlus, sumCross));
                }
            }
            System.out.println("#" + t + " " + maxFlies);
        }
    }
}