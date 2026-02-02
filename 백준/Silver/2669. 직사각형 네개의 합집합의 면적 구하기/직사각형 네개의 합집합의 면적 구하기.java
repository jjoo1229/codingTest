import java.util.*;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int[][] isSelected = new int[100][100];
        
		for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for (int j = x1; j < x2; j++){
                for (int k = y1; k < y2; k++){
                    isSelected[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (isSelected[i][j] == 1) answer++;
            }
        }
        System.out.printf("%d", answer);
    }
}