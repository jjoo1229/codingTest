import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int a = sc.nextInt();
			list[i] = a;
			sum += a;
		}

		int value = sum - 100;
		int no1 = 0, no2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 1; j < 9; j++) {
				if (list[i]+ list[j] == value) {
					no1 = list[i];
					no2 = list[j];
					break;
				}
			}
		}
		Arrays.sort(list);
		for (int l : list) {
			if (l != no1 && l != no2) System.out.println(l);
		}
	}
}