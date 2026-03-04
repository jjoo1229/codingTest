import java.io.*;
import java.util.*;

public class Main {
	public static int n, k, answer;
	public static Set<Character> totalChar;
	public static List<List<Character>> list;
	public static List<Character> totalCharList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (k < 5) {
			System.out.print(0);
			System.exit(0);
		}

		list = new ArrayList<>(); // 전체 set 모음
		totalChar = new HashSet<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			list.add(new ArrayList<>(getChar(line))); // 각 라인별 알파벳 뭐 있는지 추출하기
		}

		if (totalChar.size() == 0 || totalChar.size() <= k - 5) {
			System.out.print(n);
		} else {
			boolean[] visited = new boolean[totalChar.size()];
			totalCharList = new ArrayList<>(totalChar); // 전체 set 모음
			comb(0, k - 5, totalChar.size(), visited);

			System.out.print(answer);
		}
	}

	public static Set<Character> getChar(String line) {
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'a' || line.charAt(i) == 'n' || line.charAt(i) == 't' || line.charAt(i) == 'i' || line.charAt(i) == 'c')
				continue;

			set.add(line.charAt(i));
			totalChar.add(line.charAt(i));
		}

		return set;
	}

	public static void comb(int index, int r, int total, boolean[] visited) {
		if (r == 0) {
			solve(visited);
			return;
		}

		for (int i = index; i < total; i++) {
			visited[i] = true;
			comb(i + 1, r - 1, total, visited);
			visited[i] = false;
		}
	}

	public static void solve(boolean[] visited) {
		int nums = 0;
		List<Character> li = new ArrayList<>();

		for (int i = 0; i < totalCharList.size(); i++) {
			if (visited[i]) { // totalCharList.get(i)가 뽑힌 거임
				li.add(totalCharList.get(i));
			}
		}

		for (int i = 0; i < list.size(); i++) { // 모든 문자열 set을 돌면서
			int count = 0;

			for (char l : list.get(i)) {
				if (li.contains(l)) {
					count++;
				}
			}

			if (count == list.get(i).size()) {
				nums++;
			}
		}

		answer = Math.max(answer, nums);
	}
}