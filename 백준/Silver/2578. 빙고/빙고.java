import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] cs = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cs[i][j] = sc.nextInt();
            }
        }
        boolean[][] checked = new boolean[5][5];

        for (int count = 0; count < 25; count++) {
            int n = sc.nextInt();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (cs[i][j] == n) {
                        checked[i][j] = true;
                        if (countLines(checked) >= 3) {
                            System.out.print(count + 1);
                            System.exit(0);
                        }
                    }
                }
            }
        }
             
    }

    public static int countLines(boolean[][] arr) {
        int count = 0;

        // 가로줄 확인
        for (int i = 0; i < 5; i++) {
            boolean same = arr[i][0];
            for (int j = 1; j < 5; j++) {
                if (!arr[i][j]) same = false;
            }
            if (same) count++;
        }

        // 세로줄 확인
        for (int j = 0; j < 5; j++) {
            boolean same = arr[0][j];
            for (int i = 1; i < 5; i++) {
                if (!arr[i][j]) same = false;
            }
            if (same) count++;
        }

        // 대각선1 확인
        boolean same = arr[0][0];
        for (int i = 1; i < 5 && same; i++) {
            if (!arr[i][i]) same = false;
        }
        if (same) count++;
        

        // 대각선2 확인
        same = arr[0][4];
        for (int i = 1; i < 5 && same; i++) {
            if (!arr[i][4 - i]) same = false;
        }
        if (same) count++;

        return count;
    }
}