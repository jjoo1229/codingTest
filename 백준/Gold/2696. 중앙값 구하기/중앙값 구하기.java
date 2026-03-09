import java.io.*;
import java.util.*;

public class Main {
	public static int t, m;
	public static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= t; tc++) {
			m = Integer.parseInt(br.readLine());
			int[] result = new int[(m + 1) / 2];
			int index = 0;
			pq = new PriorityQueue<>((a, b) -> a - b);
			StringTokenizer st = null;

			for (int i = 1; i <= m; i++) {
				// st가 비어있거나 처음 시작할 때 다음 줄을 읽어옴
				if (st == null || !st.hasMoreElements()) {
					st = new StringTokenizer(br.readLine());
				}
				int num = Integer.parseInt(st.nextToken());
				pq.add(num);
				if (i % 2 == 1) { // 홀수번째면
					result[index++] = printMid();
				}
			}

			for (int i = 0; i < result.length; i++) {
				if (i == 0) sb.append(result.length).append("\n");
				sb.append(result[i]).append(" ");
				if (i % 10 == 9 || i == result.length - 1) sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static int printMid() {
		ArrayList<Integer> temp = new ArrayList<>();
		int index = (pq.size() - 1) / 2;
		for (int i = 1; i <= index; i++) {
			temp.add(pq.poll());
		}
		int answer = pq.peek();
		for (int i = 0; i < temp.size(); i++) {
			pq.add(temp.get(i));
		}
		return answer;
	}
}