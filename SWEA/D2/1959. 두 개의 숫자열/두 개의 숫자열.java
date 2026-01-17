import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

			for (int i = 0; i < n; i++) {
            	a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
            	b[i] = sc.nextInt();
            }
            
            // 짧은 배열 / 긴 배열 정리
            int[] shortArr, longArr;
            
            if (n <= m) {
                shortArr = a;
                longArr = b;
            } else {
                shortArr = b;
                longArr = a;
            }
            
            int max = Integer.MIN_VALUE;
            
            for (int start = 0; start <=longArr.length - shortArr.length; start++) {
                int sum = 0;

                for (int i = 0; i < shortArr.length; i++) {
                    sum += shortArr[i] * longArr[start + i];
                }
                max = Math.max(max, sum);
            }
            System.out.printf("#%d %d%n", test_case, max);
		}
	}
}