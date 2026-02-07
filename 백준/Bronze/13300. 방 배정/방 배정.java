import java.util.*;

public class Main {
	public static void main(String[] args) {
		int first_f = 0, first_m = 0, second_f = 0, second_m = 0, third_f = 0, third_m = 0, fourth_f = 0, fourth_m = 0,
				fifth_f = 0, fifth_m = 0, sixth_f = 0, sixth_m = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			switch (y) {
			case (1):
				if (s == 0)
					first_f++;
				else
					first_m++;
				break;
			case (2):
				if (s == 0)
					second_f++;
				else
					second_m++;
				break;
			case (3):
				if (s == 0)
					third_f++;
				else
					third_m++;
				break;
			case (4):
				if (s == 0)
					fourth_f++;
				else
					fourth_m++;
				break;
			case (5):
				if (s == 0)
					fifth_f++;
				else
					fifth_m++;
				break;
			case (6):
				if (s == 0)
					sixth_f++;
				else
					sixth_m++;
				break;
			}
		}
		double sum = Math.ceil(first_f / (double) k) + Math.ceil(first_m / (double) k)
				+ Math.ceil(second_f / (double) k) + Math.ceil(second_m / (double) k) + Math.ceil(third_f / (double) k)
				+ Math.ceil(third_m / (double) k) + Math.ceil(fourth_f / (double) k) + Math.ceil(fourth_m / (double) k)
				+ Math.ceil(fifth_f / (double) k) + Math.ceil(fifth_m / (double) k) + Math.ceil(sixth_f / (double) k)
				+ Math.ceil(sixth_m / (double) k);
		System.out.print((int) sum);
	}
}