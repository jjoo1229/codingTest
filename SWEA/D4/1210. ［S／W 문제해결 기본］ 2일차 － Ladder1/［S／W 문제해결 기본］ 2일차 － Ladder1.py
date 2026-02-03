import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
    		sc.nextInt();
            
            int[][] arr = new int[100][100];
            int startX = 99, startY = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
            		arr[i][j] = sc.nextInt();
                    if (arr[99][j] == 2) {
                        startY = j;
                    }
                }
            }

            int nx = startX, ny = startY;

            while (nx > 0) {
                nx--;

                if (ny - 1 >= 0 && arr[nx][ny - 1] == 1) {
                    while (ny - 1 >= 0 && arr[nx][ny - 1] == 1) {
                        ny--;
                    }
                } else if (ny + 1 < 100 && arr[nx][ny + 1] == 1) {
                    while (ny + 1 < 100 && arr[nx][ny + 1] == 1) {
                        ny++;
                    }
                }
            }
			System.out.printf("#%d %d%n", test_case, ny);
		}
    }    
}