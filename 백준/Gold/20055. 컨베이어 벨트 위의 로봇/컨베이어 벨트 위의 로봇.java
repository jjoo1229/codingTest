import java.io.*;
import java.util.*;

public class Main {
	public static StringTokenizer st;
	public static int n, k;
	public static int[][] belt;
	public static int[][] robotPosition;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new int[2][n];
		robotPosition = new int[2][n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			belt[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n - 1; i >= 0; i--) {
			belt[1][i] = Integer.parseInt(st.nextToken());
		}

		int level = 0;
		while (true) {
			level++;
			rotateBelt();
			rotateRobot();
			handleRobot();
			if (checkBelt()) break;
		}
		System.out.print(level);
	}

	public static void rotateBelt() {
		int tempN = belt[0][n - 1];
		for (int j = n - 1; j > 0; j--) { // 윗줄 이동
			belt[0][j] = belt[0][j - 1];
		}
		int temp2N = belt[1][0];
		for (int j = 0; j < n - 1; j++) { // 아랫줄 이동
			belt[1][j] = belt[1][j + 1];
		}
		belt[0][0] = temp2N;
		belt[1][n - 1] = tempN;
	}

	public static void rotateRobot() {
		int tempN = robotPosition[0][n - 1];
		for (int j = n - 1; j > 0; j--) { // 윗줄 이동
			robotPosition[0][j] = robotPosition[0][j - 1];
		}
		int temp2N = robotPosition[1][0];
		for (int j = 0; j < n - 1; j++) { // 아랫줄 이동
			robotPosition[1][j] = robotPosition[1][j + 1];
		}
		robotPosition[0][0] = temp2N;
		robotPosition[1][n - 1] = tempN;
	}

	public static void handleRobot() {
		if (robotPosition[0][n - 1] == 1)
			robotPosition[0][n - 1] = 0;

		for (int j = n - 1; j > 0; j--) { // 로봇 이동
			if (robotPosition[0][j] == 0 && robotPosition[0][j - 1] == 1 && belt[0][j] > 0) {
				robotPosition[0][j] = 1;
				robotPosition[0][j - 1] = 0;
				belt[0][j] -= 1;
			}
		}
		if (robotPosition[0][n - 1] == 1)
			robotPosition[0][n - 1] = 0;

		if (belt[0][0] != 0) {
			robotPosition[0][0] = 1;
			belt[0][0] -= 1;
		}
	}

	public static boolean checkBelt() { // 내구도 체크하는 함수
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (belt[i][j] == 0)
					count++;
			}
		}

		if (count >= k) return true;
		return false;
	}
}