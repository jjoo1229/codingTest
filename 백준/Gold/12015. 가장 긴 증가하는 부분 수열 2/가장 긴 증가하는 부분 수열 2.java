import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int[] blocks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		blocks = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> LIS = new ArrayList<>(); // 증가하는 수열을 저장하는 리스트
		LIS.add(blocks[0]);

		for (int i = 1; i < n; i++) {
			int current = blocks[i];
			if (current > LIS.get(LIS.size() - 1)) { // LIS 마지막 원소보다 크면 뒤에 추가
				LIS.add(current);
			} else { // 작으면 LIS 속 원소 중 현재 숫자보다 크거나 같은 첫 번째 위치를 찾아, 그 숫자를 현재 숫자로 교체
				int index = binarySearch(LIS, current);
				LIS.set(index, current);
			}
		}
		System.out.print(LIS.size());
	}

	public static int binarySearch(List<Integer> list, int target) {  // LIS 리스트 안에서 target보다 커지거나 같은 인덱스 반환
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
