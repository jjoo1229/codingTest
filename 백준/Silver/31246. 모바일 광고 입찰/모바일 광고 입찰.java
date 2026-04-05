import java.util.*;
import java.io.*;

public class Main {
	public static int n, k;
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int curCount = 0;
		ArrayList<Integer> subs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a >= b)
				curCount++; // 현재까지 낙찰 가능한 개수
			else
				subs.add(b - a); // 얼마나 더해야 하는지
		}

		if (curCount >= k) System.out.print(0);
		else {
			Collections.sort(subs);  // 정렬 먼저 하고
//			k-curCount만큼 더해줘야 함
			System.out.print(subs.get(k - curCount - 1));
		}
	}
}