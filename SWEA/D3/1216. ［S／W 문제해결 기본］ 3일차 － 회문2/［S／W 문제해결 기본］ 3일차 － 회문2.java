import java.util.*;
import java.io.*;
 
public class Solution {
    public static int tc, answer;
    public static char[][] map = new char[100][100];
    public static char[][] nMap = new char[100][100];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = line.charAt(j);
                    nMap[j][i] = map[i][j];
                }
            }
 
            answer = 1;
            for (int i = 0; i < 100; i++) {
                solve(map[i]);
                solve(nMap[i]);
            }
 
            if (t!=10) System.out.printf("#%d %d%n", tc, answer);
            else System.out.printf("#%d %d", tc, answer);
        }
    }
 
    public static void solve(char[] row) {  // 한 줄 검사
        for (int i = 0; i < 99; i++) {
            for (int j = i + 1; j < 100; j++) {
                answer = Math.max(answer, checkRow(i, j, row)); // i부터 j까지 큐에 넣기
            }
        }
    }
 
    public static int checkRow(int i, int j, char[] row) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        for (int idx = i; idx <= j; idx++) {
            q.add(row[idx]);  // i부터 j까지 큐에 넣기
        }
        int length = q.size();
        while (q.size() > 1) {
            char head = q.pollFirst();
            char tail = q.pollLast();
            if (head != tail) return -1;
        }
        return length;
    }
}