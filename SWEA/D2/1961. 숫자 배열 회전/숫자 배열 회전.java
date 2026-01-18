import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];
            int[][] r90 = new int[N][N];
            int[][] r180 = new int[N][N];
            int[][] r270 = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 회전
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    r90[j][N - 1 - i] = arr[i][j];
                    r180[N - 1 - i][N - 1 - j] = arr[i][j];
                    r270[N - 1 - j][i] = arr[i][j];
                }
            }

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                // 90도
                for (int j = 0; j < N; j++) {
                    System.out.print(r90[i][j]);
                }
                System.out.print(" ");

                // 180도
                for (int j = 0; j < N; j++) {
                    System.out.print(r180[i][j]);
                }
                System.out.print(" ");

                // 270도
                for (int j = 0; j < N; j++) {
                    System.out.print(r270[i][j]);
                }
                System.out.println();
            }
        }
    }
}