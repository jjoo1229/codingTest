import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
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
            
            List<Integer> result = new ArrayList<>();
            int idx = 0;
            int max = Integer.MIN_VALUE;
            
            if (n < m) {
                while (idx <= m - n) {
                    int sum = 0;

                    for (int i = 0, j = idx; i < n; i++, j++) {
                        sum += a[i] * b[j];
                    }
                    max = Math.max(max, sum);
                    idx++;
                }
            } else {
            	while (idx <= n - m) {
                    int sum = 0;

                    for (int i = 0, j = idx; i < m; i++, j++) {
                        sum += a[j] * b[i];
                    }
                    max = Math.max(max, sum);
                    idx++;
                }
            }
            System.out.printf("#%d %d%n", test_case, max);
		}
	}
}