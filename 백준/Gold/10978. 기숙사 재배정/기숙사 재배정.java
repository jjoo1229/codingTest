import java.io.*;

public class Main {
	public static int t;
	public static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			dp = new long[n + 1];
			if (n >= 2) dp[2] = 1;
			if (n >= 3) dp[3] = 2;
			if (n >= 4) {
				for (int d = 4; d <= n; d++) {
					dp[d] = (d - 1) * (dp[d - 2] + dp[d - 1]);
				}
			}
			System.out.println(dp[n]);
		}
	}
}