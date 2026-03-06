import java.util.*;
import java.io.*;

public class Solution {
	public static int t, n, size, k;
	public static char[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			size = n / 4;
			k = Integer.parseInt(st.nextToken());

			nums = new char[n];
			String line = br.readLine();
			for (int i = 0; i < n; i++) {
				nums[i] = line.charAt(i); // 배열에 다 저장
			}
			Set<String> set = new HashSet<>();
			// 회전은 n/4+1번하면서
			for (int i = 0; i < size + 1; i++) {
				nums = rotateArr(nums); // 시계방향 한 칸 돌리고
				char[] arr1 = new char[size];
				char[] arr2 = new char[size];
				char[] arr3 = new char[size];
				char[] arr4 = new char[size];
				divideArr(nums, 0, arr1);
				divideArr(nums, size, arr2);
				divideArr(nums, size * 2, arr3);
				divideArr(nums, size * 3, arr4);
				set.add(makeStr(arr1));
				set.add(makeStr(arr2));
				set.add(makeStr(arr3));
				set.add(makeStr(arr4));
			}

			ArrayList<Integer> list = new ArrayList<>();
			for (String s : set) {
				list.add(Integer.parseInt(s, 16));
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.printf("#%d %d%n", tc, list.get(k - 1));
		}
	}

	public static char[] rotateArr(char[] arr) { // 시계 방향으로 한 칸 돌리기
		char temp = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
		return arr;
	}

	public static void divideArr(char[] arr, int startIdx, char[] dest) { // 네 개로 자른다
		System.arraycopy(arr, startIdx, dest, 0, size);
	}

	public static String makeStr(char[] arr) { // 배열을 String으로 만든다
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
