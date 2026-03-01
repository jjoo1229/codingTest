import java.util.*;
import java.io.*;

public class Main {
	public static int n, m, x, y, k;
	public static int nx, ny;
	public static int[][] map;
	public static int[] command;
	public static int[] dice;
	public static boolean moved;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		command = new int[k];
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			command[i] = Integer.parseInt(st3.nextToken());
		}

		dice = new int[6]; // 위 , 남, 아래, 북, 동, 서
		
		nx = x;
		ny = y;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			rollDice(x, y, command[i]);
			x = nx;
			y = ny;
			if (moved) sb.append(dice[0]).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static boolean rollDice(int x, int y, int dir) {
		nx = x;
		ny = y;
		moved = true;
		
		switch (dir) {
		case 1: // 동
			ny = y + 1;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				moved = false;
				ny = y;
				break;
			}

			int temp = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[4];
			dice[4] = temp;

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[2];
			} else {
				dice[2] = map[nx][ny];
				map[nx][ny] = 0;
			}
			break;
		case 2: // 서
			ny = y - 1;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				moved = false;
				ny = y;
				break;
			}

			int temp2 = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp2;

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[2];
			} else {
				dice[2] = map[nx][ny];
				map[nx][ny] = 0;
			}
			break;
		case 3: // 북
			nx = x - 1;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				moved = false;
				nx = x;
				break;
			}

			int temp4 = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = temp4;

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[2];
			} else {
				dice[2] = map[nx][ny];
				map[nx][ny] = 0;
			}
			break;
		case 4: // 남
			nx = x + 1;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				moved = false;
				nx = x;
				break;
			}

			int temp3 = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp3;

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[2];
			} else {
				dice[2] = map[nx][ny];
				map[nx][ny] = 0;
			}
			break;
		}

		return moved;
	}
}