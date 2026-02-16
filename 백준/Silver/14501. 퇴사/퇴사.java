import java.io.*;
import java.util.*;

public class Main {
	public static int n, answer;
	public static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new int[] { t, p });
		}

		answer = 0;
		dfs(0, 0);
		System.out.print(answer);
	}

	public static void dfs(int index, int money) {
		if (index >= n) {
			answer = Math.max(money, answer);
			return;
		}
		
		int[] cur = list.get(index);
		int day = cur[0];
		int earn = cur[1];
		
		if (index + day <= n) {
			dfs(index + day, money + earn);
		}
		
		dfs(index + 1, money);  // index날 상담을 안 한 채로 다음 날로 넘어가는 경우
	}
}
