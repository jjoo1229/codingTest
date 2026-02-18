import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int[][] players; // [이닝][선수번호]
	public static int[] lineUp = new int[10];
	public static boolean[] visited = new boolean[10];
	public static int maxScore = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		players = new int[n + 1][10];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		lineUp[4] = 1; // 4번 타자는 1번 선수로 고정
		visited[1] = true;

		findOrder(1); // 1번 타석(depth 1)부터 순열 시작

		System.out.println(maxScore);
	}

	public static void findOrder(int depth) { // 타순 정하기(순열)
		if (depth == 10) {
			playGame();
			return;
		}

		if (depth == 4) { // 4번 타자는 정해졌으므로 건너뜀
			findOrder(depth + 1);
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lineUp[depth] = i;
				findOrder(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void playGame() {
		int score = 0;
		int playerNum = 1; // 1번 타자부터 시작

		for (int i = 1; i <= n; i++) {
			int outCount = 0;

			boolean b1 = false, b2 = false, b3 = false;

			while (outCount < 3) {
				int result = players[i][lineUp[playerNum]];

				switch (result) {
				case 0:
					outCount++;
					break;
				case 1:
					if (b3) score++;
					b3 = b2; b2 = b1; b1 = true;
					break;
				case 2:
					if (b3) score++;
					if (b2) score++;
					b3 = b1; b2 = true; b1 = false;
					break;
				case 3:
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					b3 = true; b2 = false; b1 = false;
					break;
				case 4:
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					score++; // 본인
					b3 = false; b2 = false; b1 = false;
					break;
				}
				// 다음 타자로 넘어간다
				playerNum = (playerNum % 9) + 1;
			}
			maxScore = Math.max(maxScore, score);
		}
	}
}