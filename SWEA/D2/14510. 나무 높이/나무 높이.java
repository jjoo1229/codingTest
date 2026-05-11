import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, max;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			System.out.printf("#%d %d%n", test_case, solve(arr));
		}
	}

	// 나무가 자라야 할 높이에서 필요한 1, 2의 개수 구하기
	public static int solve(int[] arr) {
		int even = 0, odd = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < max) {
				int num = max - arr[i];
				even += num/2;
				odd += num%2;
			}
		}
		
		// 2 -> 1로 변경
		if (even > odd) {
			while (Math.abs(even - odd) > 1) {
				even--;
				odd+=2;
			}
		}
		
		int result = 0;
		if (odd > even) {  // 1이 많을 경우
			result = odd * 2 - 1;
		} else if (even > odd) {  // 2가 많을 경우
			result = even * 2;
		} else {  // 1과 2의 숫자가 같은 경우
			result = odd + even;
		}
		
		return result;
	}
}