import java.util.*;
import java.io.*;

public class Solution {
	public static int t, win, lose;
	public static int[] cards;
	public static int[] result;
	public static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			cards = new int[9];
			selected = new boolean[19];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
				selected[cards[i]] = true;
			}
			
			win = 0;
			lose = 0;
			result = new int[9];
			perm(0, selected, result);

			System.out.printf("#%d %d %d%n", tc, win, lose);
		}
	}

	public static void perm(int depth, boolean[] selected, int[] result) {
		if (depth == 9) {
			getWinner(cards, result);
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (!selected[i]) {
				selected[i] = true;
				result[depth] = i;
				perm(depth + 1, selected, result);
				selected[i] = false;
			}
		}
	}

	public static void getWinner(int[] GY, int[] IY) {
		int GYscore = 0, IYscore = 0;
		for (int i = 0; i < 9; i++) {
			if (GY[i] > IY[i]) {
				GYscore += GY[i] + IY[i];
			} else {
				IYscore += GY[i] + IY[i];
			}
		}
		if (GYscore > IYscore) win++;
		if (GYscore < IYscore) lose++;
	}
}