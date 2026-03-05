import java.io.*;
import java.util.*;

public class Solution {
	public static int t, n;
	public static int[][] mag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			mag = new int[n][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				mag[i][0] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n; i++) {
				mag[i][1] = Integer.parseInt(st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < n; i++) {
				sb.append(solve(i)).append(" ");
			}

			System.out.printf("#%d %s%n", tc, sb.toString());
		}
	}

	public static String solve(int i) {
		double left = mag[i - 1][0]; 
		double right = mag[i][0];
		double mid = 0.0;

		for (int iter = 0; iter < 100; iter++) {  // 실수 범위 이진탐색에서는 while문 대신 반복횟수를 100번 정도로 고정하기
			mid = (left + right) / 2.0;
			double leftPower = calLeftPower(i, mid);
			double rightPower = calRightPower(i, mid);

			if (leftPower < rightPower) {
				right = mid;
			} else if (leftPower == rightPower) {
				break;
			} else {
				left = mid;
			}
		}

		return String.format("%.10f", mid);
	}

	public static double calLeftPower(int index, double x) {
		double power = 0;
		for (int i = 0; i < index; i++) {
			power += mag[i][1] / ((x - mag[i][0]) * (x - mag[i][0]));
		}
		return power;
	}

	public static double calRightPower(int index, double x) {
		double power = 0;
		for (int i = index; i < n; i++) {
			power += mag[i][1] / ((x - mag[i][0]) * (x - mag[i][0]));
		}
		return power;
	}
}